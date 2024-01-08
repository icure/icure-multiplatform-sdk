package com.icure.sdk.crypto

import com.icure.sdk.crypto.RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
import com.icure.sdk.crypto.RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256
import com.icure.sdk.utils.base64Decode
import com.icure.sdk.utils.base64Encode
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray
import kotlin.random.Random

// Private keys in pkcs8 used for encryption and signing
private val dataSamplesKeys = listOf(
    Pair(
        RsaCryptoService.KeySize.RSA_2048,
        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDRwnz+NTVzKu7mPhVqLMT6clQG/FZAkv7ATpfbGZpjsuIRj/8ZU3a9oXmIH4f0" +
            "wKbqN9lRECwmfgWxaXdjoUilDXqMUrk4onHa/EfFfzb+BPxGj1cM0wVyZiYbq68vdmI4TAZicB8BUngvX74EJFA31Df5nghjnKnqpqbHaKtw" +
            "+kiWRCE5Guz6A3BdcDc/qDmBd9vSqLryfljXMF1bZGXlzcyjegqy9jaYFi0vuQOoXOPWLnHmMU29Rdiw+8UEHqHE6DRLgGXrumSDFE68L0va" +
            "gbnh+Ea+dEQ9PNrWJShVk0xO6rjwhbEZdxqf+KYX5lMic/cR7wGHfGvi2XpQOo35AgMBAAECggEAYzSEMChTKK5oAZ3gO/CDkt2Kjyk909mR" +
            "wbsKCBZCVh/O2raLVFuMn6AknfQntWJ+Lu0OC1BGSUg2AhPa4tRvSpym1oHzVu1BQuwpN6d0h0wtUmPNrGOLQnE8Wb7nol9vkaenJ1xW1aW+" +
            "8MzrzgKsq9LjTFvpJM9971w1Kb9/wfTKNkd3jTC2oc+Ub/MVK4hCvU0/7DxMTDalTzrGKoRZQgdlFZ3FufK9Voyiz5J1K1nLVLme0EibGd2t" +
            "aYwggPKr2bGaIJBCENxIQbIPESwu6ZL5dTsmqtNRALGnVH/utvegBpsu7SMlCXE13CyI4EFD1c9wFrBNjSPx2ZjYrtFXfwKBgQDqAW10LhzF" +
            "pn6uyYDEixxm1ilvWg//0dS0ixr2hE+dPcDY1mz2S8OA+vkJ5kMWBn922UR7Ns7RpNoyHZUaY9rAvUtiU+25ZEmEGYEn9sadVw4CKEwQlM42" +
            "SQYRW0riBbOkcGxsbYbhOLC20+ti+OmV/JODAP2iP7VEc2moqaAmkwKBgQDleaoD7/ZQGy0fkno4HxEEkBeXvdHeR2c4eTphGgjnm+qeHonF" +
            "ZsTVhm8g8qdRECFrKqd0oJSk6sLREE9HrOE2HicKWgllSa3tmTc8bup0ZSIZcF3gnydAX19eZKU7XXx6gu79++5YgqNRiWvLDcHcqRoRE+8B" +
            "AWepF8762L2kwwKBgBMI6LFhqt99CqMHKx1Rv46x7w7qwZBqriW9hwT0gFFnG4/H6XcjdJTCVY2zmFNrVeUCCWsIa0xsX39iHqXV5450F3S5" +
            "JQZGnSBMvs/UaBWWZkJQqtdSc2/BAuhYh7/Y/OLsbjVnt2gMp3tHw8b6Pm3/7LPkWb1f90vJI5gfrDJXAoGBAMzwxXhSvOZ5/uitht3MUQSE" +
            "M63fZylfF76F9i92cvF2fCjPGTflOnGAaItCa0+oWlA9feRY7agDyg2wxT08Fr6gWzmRg8aj8OO77GranCVrlPKnOhA703BYPPIubKsCKQO5" +
            "H/xRHWKK+ZT+Z/imxrZth8wsw01gldWcX8wD+grFAoGBAMtCWVmb2Qbl2ioatqaBmLKQin6rqvnz3DSIPZQ+Vc+G3K2+Ayl5idVfv3N929c9" +
            "SddU0+LL7HrLUX9b8swAkMn6tSF6wcT4prCVkaa4Iti85Q/DMqs2He2Y+dGI6+ZUORih68SwP9w3J8LYPdBzuMGM3IJG8fyUkxPKSVbeixZq"
    ),
    Pair(
        RsaCryptoService.KeySize.RSA_4096,
        "MIIJQgIBADANBgkqhkiG9w0BAQEFAASCCSwwggkoAgEAAoICAQCzfY2orHA37YIxLcQwSwxx54DjJ4BzzoloyjdPTkg5LR40XD00ez1h3H+q0EZ8" +
            "l3mfkzHQ7vzNRmy4kjxYbFr8vbx1Tslgeef4kDzAaozILizFx6rGMpBz/0xtxOyEEdTlq+UDEPB5xd8m2cjPfAtHp5wCh3KGz28LNhj3BvhB" +
            "qn5nlRvXDFHZmd6OLNX6CJMB6GnuJYM50wJn3UV7swOby7q6ruoxVEd9bXEpCPAmMAty3n3mdA6d67QFkwk3/hu4uARG4YpzOmw/pdNJoT/E" +
            "v3mjxUoaNUr3b3VNE79tda/1plXICHdxALEO4mJV6hsA7pYCnK0x4ksF/WOwQVfozUAbsMjJqvvrfGLl9cHSUZQyktSl465a+hrWmBw7tmC/" +
            "EDBuBY+W7q6ek1KEDcVV2FioGxe4WpFG2ZDhbzECyMBdEfrmWochEWgK1MNNYvKQseJrb1yDmKBGJg0ZGYXTtzZQxPrkreEKXwuPluEDNwQT" +
            "2t+lStUS8F7X6jkRrJmBsflJzUVYYpDF2X5z0CL9y6brGz0DFhWRPEgsBo7U1v/jyMv0HflZXh3JatHYh/17mrZ5QjTxEJRwZAiKo62IK6Kc" +
            "sGVZ3sQjCSS/b8Wgpj6iFbepDHLGEa6XSJfATVuuHcqsslxOwj6r5Qe8XD0v6hLL222LoYv8aqp5UM/IeQIDAQABAoICAAdrWDCxuA3Hxorr" +
            "3mE0qPYIYL6DAn9G+U0YlsKzdK7QW6BEc884jOf/qlNQOqmpxUBAYF3HkzGVCKd0fAQXrocl/KVItXBEeb8/jxNRFDKuHfGq+DcrHed9lRYw" +
            "fqpS5l78BQJkb9xIvpmnhPJ2qSy0E/HS0XwbFPb8rHmBkz97oa/8bOMtwjBheN6dodatBg6dIcvTRyJbw4yxi866LpsBB93xnwKc/juEC5pr" +
            "oSmi8MY1xjSBdZ03ggB8/HOREGpJSPv5FLUApDrZSuuPO8iRNaD8ZbzBmTCzLcEa4N3QcI6R6pfTKcTFB4ya9P+iJq2aLx86hLo8JWfA+p7t" +
            "hImsJ+cYcZp9pQ0igOndgIawlNYejgfPN7Qm9dzz7DltIVFIEK9AoRVS89snOJDH+5ripQuxEB3Au2EhVx74HsOXXz3qeZtnd3SDpM47Xrz6" +
            "6pQTLewRMnGeObxYr34AZgCQiNf9GnRjBR4D/lvRJJ+LkpQcnC/ao7nmDsgpKPmLkCPG8QFW30KdVEX8W/fVWBODON0MaygUyQXFjHkkyydw" +
            "vfw2KcQrzQNRcNbORsW552McdPZsKUkHq0WVw6PVf+4yt39SmQ+ZtPn9DP/kj5SzP728oSHc8LYHjfeWLT91VGnw34C9L4y2r2RBQVsqphTh" +
            "wPZXyq9d0sc0M2QPL0CBAoIBAQDua1toGtqQgBO8Liy9AZHzO7CY32WrY8gJEUgSESKqsU4w3web0qxF3bCDP2bSjU/jq8ejhlC36eWb6u3A" +
            "yyleTStm1kAsyNFfIegCoJUXraBen9+G6dmTpBqjJa1DV1GkOPSnPaRarQCXdbHWPP+2Qn2XhWsQKGxAs9rKoRFT+Ar6dHZLpGPILM/E0Tfm" +
            "ZnqAIk6Hiysixto5sxZmgQJ8zk7a7O7dcAefZtw9NCt6NAIX+BazFEOWxzcrEYufZYMrNPDqA6V5xAyBotyT1/Tlm3SM92LILHQCnzoKEG/r" +
            "k+ArUk5bGSB6nxnFJdmYLwJV9Dd771P9e1e9yrmV4knpAoIBAQDAuct/I8gNM9rRHeoJ78RHtebdf9kArUqWIIdEcZje0nYgzz5o80IpsmWA" +
            "1urn1WC/GbV1mgWPFHIWmJkgrF+Xuyz4ZQPSL7aAudDHRV5Esi5vO2+L+pKFMBc/oqeqVVncbLnFPtvTrOZtHR0FHIfIwNxdN5i+0yf7fKnH" +
            "sjSl9hp6NYOqZV/mMJ47DEhbhc+fZffWTDWCv5brsLUdnbkJQvleU/rNs6Tcp/jin3ijFgShEje9LTphG9LIBCtrHpALUxzh2Eh/Z+CpbxYG" +
            "aJcq6HKUGnmq8RWl+f5yhOQ4NnAtHNW5O0CXLqYxHjs3mu7AdGBTrYv7Lh/nsPJsFeARAoIBAQCvNsCXMlz7otReEEUapeO/sFcpEcwi95KT" +
            "b1raxDMI5ILFEbMCxgGK2tAUtGx5Qha7B4wQ1e3OKxttyWnurJ97SRUjX0MMZozP8BgUjjTjkNrxj2ZzPLqEcS6ORWseuTYrjRvnKDr31HpB" +
            "1OHbwzpdlGG+D/PNjRd5OXQKQ/J7FifjReGF14rpGl2ak/MT5K4UKqIxpIoP5bmMe9tze037sJZs94DXxbQkZjBm3kcxaLU9LjpoYvUFAuS9" +
            "RwioHK8X+rEuGX3rjbNvNeQK1sOIVgWCb2/uEhUztBawPMIzi5pL3BHvivi+hNwocZeG6s05o99+ujSsbY/ez/QxfXq5AoIBAGXMfeHdS5k1" +
            "r7pPm8S94iaivZx4IG6MGl6sNecAPehMsNrpvSSAgY02zwi7/P6SJfUrJj9FKPSHry+iURgCFMg3tSxLZzZJv5PFErN/P6j3mTFl6qi8pVI2" +
            "scEKMJf3V2zn/URjzIfFxz0RaLe/dzWiMYQHjuYU8QSUt7VkuwyCrz+oLrD9tScIvTuhZEL7rkya9ss6G/XBL321LCXFnux2dPPPViX7YvSu" +
            "wPcrlvRF+BIAZnLFhhWvNaozEaAWV62zrAjbTogFnZTBuZeO/XJLr+HtDiEuEOpH35AsA8RxdNVPatDZrGdu25gMSOk5LC16CzuH6u21UmL2" +
            "g0Z2U5ECggEATX+elkqmmRgY1l0ZZN/ACHmkvLnLWDHMU1pmLLEtCBYTWWpBp1gD0VsxOgg0UkFoh7ECAgMrtVbA9luPnSj32erCo0C50wVx" +
            "zqa2VRzg6rlQl9ZNAFSMtmxBDJTvQ2yWpw4GOgQifK4TYqxyd15nlI3BYxXao7Jf4oc/N7noMh9MTUECWHHtvnqi04rp0jg2mSXry942+uOT" +
            "OHuTRlqaPeGGx1TxDVg94Yrm6IFYIfJDPpv+5bDKct1MJya4oGv7n4A48OVYMkIqAf1fHOHvvYR6tmXic2fN4ulBi7xJegjmki/HWA3pcjCB" +
            "fLX+CS54iCqSfu8ozP9+fpWj8+Ytkg=="
    )
)

// Associates data and key index to encrypted data (algorithm: OAEP with sha1)
private val dataSamplesEncrypted = listOf(
    Pair(0, 0) to "DiIIKoUuSIOf7k9OPWOsJA7/f+QL687Gtn+UlWG6AmkrOLAmChUSg3BwJvYL2OKIMkYa++aB9ugycEWuD4EdJ8QP+ZO/Y/nM/y" +
            "/ojApTJlYAmM8gjiebrZy83i3qmzAWe1LMtQ9s1jnuvk8CqGMYKN9ewoOHiH32anes5OnUqNA+9Fe2lo58FXCGF/R8K7hZtWQdtK/Ry7" +
            "8wwpsTLwNVaGk095Yc9LgrKkjWMZj26LFZGKIbLgxmP7Qqb/NQ35yKivXi2skNo71Dd2WlgSTeowO3++MhdTDvkILeUYChDjmBA3SZGL" +
            "2Xdsaj2DzZM2AJ+TxKOEeXCPPVHcaKVjdvng==",
    Pair(1, 0) to "X6QROsFgCP0gVBCU2XUXTQYaPf4UDQlG8eEJs7g2MX7+xwWUi70waN4DzXo6yxYtA4ezwuITtORf7V+b2tblD/Z70K7Ju+DFdJ" +
            "0i7U1M2sri7bXGEmDOcyRgcOU2O4mNiOrBpzybyfU5fzJGsJT0GP3RObPGX+Lc2SkxcpkIyNSy+8OLPOwHopyL0O2htmjP/HG/uuIxzE" +
            "JkqwigA80X1pDF/oG1cXfzn2g38WEZ7BHRaz3JJ+ysySbIwbS53ApoB+ikW+g7QzxGXk1aQSxnhGTUVfQXL03Tqqx4LxkdMUCHVhZK0y" +
            "jl85ewCHKRGTFDkQzxiI6PbtkIq6CQEwwepg==",
    Pair(2, 0) to "fTcJNsNf1/vHk0Xb+57Bw3sFzkkgoLVVwf6W+v9APyQh/tszkiC+PockbQ2/0tXfz8/6GaQws8NDVLmQhLjRyOECrR8hsWprn/" +
            "5A88t21t8EEL62/OWCnDxZMQlgZEg9CX4athqQxRlO8hVxwlx2jSX9oj1Wx38vTVB9JtToCcMA3HyJ2wXnagDDyhNzwGe1C1/hTzMngS" +
            "jSH/8uirmi7gtbjwdF5199WdoQ3oXTyc2T+XEzqR9smPrp1U5ZGcu4TZsgFXYBfH45Dvbi1HLR2wqEdDvzSXkyU27niCcir7j4M+/iQK" +
            "N0UD4F6Y73e7tAcM76V/LAdO1B+56b2qe5kA==",
    Pair(3, 0) to "BSbuDZBPHmfDwENUr9qOtAaDYDpovWhSgoByCDa3hutGkehbJkJvbQxI0wKw5sX0vvgHsiirfpyNLDwOrivOLexcaqHcGRSFYV" +
            "gE4NLEcP+I0ZEAOxA1AuT45JSXB9kPUuodMQR99QT3t/Il5O3HaOqu5XOqJ5jEyCcPnXIBEmbF0HpOEvAHglfbiEUQ4UIdgZwFPJ60O6" +
            "TvnJRBPo1+RBXQiGxloMuW2vn048QFlYJ97/DeBqhEUMzJQ3xvKCqN72xSGS6jf0W26Vqr4VD8PSdD7SrKzZWaGVRTw05GqzkCq20KVU" +
            "eTqN/Yq8fHL9NkMunxrcXA8OrHP+2lKQYfMA==",
    Pair(4, 0) to "YAcVnyH6lHIQ70VrXeTDyUAWol9o0n1Oxhw+uslSEmMFuPhugq97MrlvF97qpfJDA7SlsOmjHtjIAc0mpy/1y1IQ/Fbh1+TpGB" +
            "LIswp206N7z7vBixR+p9Po/lcqSCvaU6czd2erdRZ4WM5peF1VxTRu8ZFtYJKG5Y7O9HKsPq63BjFT9qBeF6zA1H+ec3H7YEfSPYleXC" +
            "ZHesYfU8PpzENryAf778gP/rkllhIAfHEwK0hFbC/nYmlIGUTeYypyD3IjStI4pqNR+jod/szFFKop+LJgz5JKV1DhdSAqMc9ND+WG/Q" +
            "QMm3od1eUCsxIrJ54A/qfmnJU/iJLhl+B29w==",
    Pair(5, 0) to "mkGoKiMFlhTJTP6VqBATj7nT2A6jjZQjn47pvuaIKjpihCgVk25CERlAFhJExvKrnTNZyJ4IUR0qdCuR6pXZbTbVjpzbMIUgtE" +
            "r6lJnW8BjNYbvfJLR6PkRqVbFKqas+4nPpaPHqWT8Zoh48IlNwOdkZRmJ4IN/c4xKRFu06ARdHoD37HW/j79esyVUR75ETU8OqdZbVgS" +
            "CB5waz1fGrQAFzayZSGN7kWHVEBRRKoEtcZ69af/Hxf9ddPLq1ri0bff5i51/98O1QYDd2/iBAon0xGS9r2tyR+POHbtaPM4A1hIOXtU" +
            "Ao8oVUm/sxsMAXcUovPNXa45ruwn2NdAm0cw==",
    Pair(0, 1) to "BPAafStLs2s/H7U/puUDDGDSbk//pew3cFSnC/Y+h/b04diJTjck7QXysCgyp3XANeav5NOPJoDNJ4A9HJoyQSYAlIOHlFkJCn" +
            "Y//XqusfS51vNqRnUOXm7IlVVnmjIMIZSyB+SGDLEQEvUOu68szi8uueY+PU79K8pB6UwlFtYvpkJYFYT64anZqi/85l70aRKs2oWz28" +
            "ms7oUnqc+6OV5LepZ/lvObR1vOvnhrQVopxD0luVeEloErwQyLUs5ofXvE+5WSITfjDO5rR9E93x6Fm3s0/alwLgvhNXc4gv2vEW8cDf" +
            "W/rGGuPJfwFKacV+G+yWGRKWbVjwE4q6AVqmvbzfrXzZG9LEjRLKSunD8UoaX121UKdj1kDp8SzbEotHA/CYgqQC9HIyMh96Fu6AsKBI" +
            "y+s4nASPexyDIWUGMSrpwWOLaPkfJboZK8dgvNK4rlEEjNXddUFflG+zW93zpXqSGExGLNxy2VkOtWz/xkYTc9kN9MGCQdQSjOoha0NA" +
            "ExsU+hbi9cmzD2frIZbA78cZ7T6ygswebNDQg1XKi4Th7VgetSQhue+UjVTbAFeSwVnd7q5tePa79kek91uVKjBtbvobKITIJplDKR/D" +
            "XapDtHBrUUq8Cnr+og2XycTspVR59cMYPIofqk5vM/ru6JksZqI+CnTRSmcfnU1Ow=",
    Pair(1, 1) to "ljYJnLrR3LzhSS6DGo4Q97oUEpPaqsuGfvcfedDpRlA3p39oi64dypYe/xS0mxJJFE+OWZdh/jQLAOnYPBM4jH7z4+huW6lENG" +
            "Wu5A8BS+MOvbHRJy1fOLTwFsCRXEuA3kpVFY7s42wfko134F7YJKD3a5dR7LdHAv2zVIA40fYgaZeFxWHhQe2qC3YYMe/B56LfBqr/x9" +
            "I9Yi3a7bpTBghHrpFW/Y5+2P+2DuF92QdQcv7DjP54f6uYzyc2CL2AY+9/OdLpoVlcFT7UdlvzSo2pN9M23//H+UO4x+7LVXWjiE5YCj" +
            "29/cUxiJ/o/VmKHPe/DZP4r/kssTsL06uMrizMqWy0feIMqw3pxow/VuKUka7ALVuKsT8SBVDtYoXfWOREqpI2QQAd+aqGklXbJQqAFp" +
            "MMBx/U08kKqJQW4sd5hiZ1rjK4VBtiH+EXXJjIEIohxe5/3ZrXzbILqX98c0FnfOPS3loafLWdJ2tki79azYYVq0UPYZQK4iQTLzMpjz" +
            "Af4a/+B8x3v8HP3QDL3fn2E6/jB9vBwbcmXVrUEVYaa92PtYy2fkc0XMyVD6+Ls6yzV79r+im6Qdg/hiIrOnkEEL2uD3x9XU4FCF3lQT" +
            "g5AiTyrHrc9wCbmGyqe7z0apWRJ+ZDL18+TiQWOoS0TkCbj7iClPUr0IqSsuvqvkI=",
    Pair(2, 1) to "JgVDGmcQ0DU/885kStkJMNXUaMx2GBWh3wpM5Flg+6pjWhR1Tn0QnZPTPkMUe/LpadiiZOi/6J0Tm9kCowClEYyTJo4Qu6AlWF" +
            "PtyP54g8EbxLPCZ1XHOI6Dh5WTq0kDobBljebCyFXy5rqkzQJyTKHWjrxupGz1AYefsV7cuenDkZ/dXe5boswUyqQKQcc4NHRPefcFCX" +
            "1BJed9bUb6RkA2bPHotuay5eZ4dIgiiTFro/JVxKd2ti21WoLe+nDRNnrTA1pDjZ7+hN7oYvgbikIMdpy0MrEZR+nYvLzzaX+z6ailKX" +
            "5PSVT4GzhltibhoP94W85tfWqtbLoDAhJGz/0qjPfDwueY4dAAPvSuxOYtG/wPSTw3N/k00jXo0n+UA9KloAlrza8NAaAYLAfIjQZoXV" +
            "8ohGmrTGF3vc5VaPvwDG4FaYy1zqwB/MmuhP8vv/WZ225QyWWze2IzQ1pCsTPU/Fu6hmBV98iHpTPHMqUW62L17c//7CbxLjhYe1nfXh" +
            "U+3JShOZ4kHG1fF/iafiYWAjlzAD50t2DNDPh+G3DlRqIZq9TXfox3mAckmFNzBI1o6skaMk2LSPH8sjlSSVvimVJQp0GqsEx2fH4J+u" +
            "hErrNTMTTUMV7FFyqiK/6qQTjG1Hwdi73nXy1EgiR2GUCQNmrEJDW9RHTrT5cvzKA=",
    Pair(3, 1) to "SxhWi+4VidO6/ECPxSrw3ycOcWP8NPGmRQHWaX4q4xSmj/g3tWzADn8EqXu7ie0lWOXjl7ZK/M7b+87/OBthCDGfln6EryYhhp" +
            "doeM3HCWwQqYMCO5QRURT6e61nHeQh4cE/Quqwbc4/gi3g+fXj0U0zpTwj0J61AUt4WbXnOHKcQo0w4U98GP5rUD+H72+ki1BGktgJBe" +
            "uBgWeQ26LwJN2u9rP+y3qL+eJcsgJlVCRimhVaT5U9+q2jRmr0ghwhYCeOX9EDwYDARo+8zKUFVIwYGXV0FKeln9Sqt03DKjummR6N0d" +
            "96bHS1+X57Tz/fjH/YMJM51I7D1Sy24uxp5qWTfsO0cSuUJ7g5ZE0pGTea9K/2i/uouDP6if6Lzp6F4aH+SLjdXVLA+1bxSjZDy7ONOG" +
            "t+3fRG1avv9Z5bAQNjkc8fZOOY8hsPnndMBHUutwE+CDUIkoSF7DcdiJqY9npmxWL2GH+wsRc71wjTHSbmiaHGs7VISd4XRTkTWkuV+j" +
            "Lax1ik+b/gQoMQHa8/0De9O+WykSrvYVLequxJrWbY+3yXhTOzlRNy5KkK159Cy09u7uWG5LGffmG0cqtncSr/A72G7brN2cXStxklyW" +
            "b4+4dqAqm8JAbCgoAalDQvEZi7tlRHK9dcYHj1EVhmMqpidOeQQ+Dbzc30vysXtps=",
    Pair(4, 1) to "XxQM6/svO/PCeHV7RDJr6T9F7DdfEfkVM1r4pQOLRBN+oCH3Xl9hsTk0yJxBPs1yV87XPumPr4RB9xcFUlY0BDGn48d8C0VgGW" +
            "XTC4Tt5wYARG4rxqQiUhY6N8j1uIWnb0EyFPOCtMV2NQ6LrTL0oWNtKtSl4Ur+pG7vzMU76OG4c5h1K1XPfPss42mvAwDTyjoum39b4f" +
            "/g3CHqZipn3m8W0GyZL3EYdAgvuo4mlcuUtFtXZTi9CoyctE+ssisjEkEZaRxCHsWuPEYpRwvDJk1ZcjeuSakdI0x3v3cKGBLhDL9mYC" +
            "cavBALc7IRvkNvnkCsoe9SyAq3QzUNblMDVBr0/fkV+8aAIULgUQfxIV8cFGkOn/C8W27dVxntExc+s1bR6N7LHoJcMIT/XLH/LljBmk" +
            "i1YVmTLUt7a3tWBHcQnPeu1C3wg6MrLK0tEnWZ8VktjkLPFEIj/fDo0C70HsQqGX02roWsb1Ni/SB0Y72cEiPG3QTyoVwQKw4Arxjj35" +
            "Ky2xkTcBZ7AllaZz695ITZWbs6FGldDxzQlQCqP+6eBazgqsP5mnASKTFeu8jxojEC5Z+ZFcJiC44rxXFUF3GZC1KG297QXIpDizcUr8" +
            "QXxsg/6UI9LppVdq2fMy4M8xA2PKynZF9/G8GYu58I+yOW009Agh0VSLHOXZFJGy4=",
    Pair(5, 1) to "ezv//IFS7vt/WiaPcF7hq9lGFYNtohuMAXy/3pWDsdkajjjnm13d6hNui6Pe0/n2vamYxT4yAulYJNhebY0GnlWkfQcCAX3moQ" +
            "TrjL3OJjivbRqPtxYW+eyoUuDz8EQK6VMoUu0/V3jMZoOD0PHqL9mozYFystX0JUzzBbg+yqvbGPcBZU90EBEGA0UviaJlVTA37rWgzx" +
            "uV6p+Sia9TYs1C8xkMS9GDz07Mjr8tmmpUddY1hyOJ+UYHk+lQ9EBC2X5xZHJJVZanwsYZPWMGkcPUWKEpLIEhkWHZ7KGjQcv6P9lgUQ" +
            "bmHtMTIEYreaOA6B2gvYoQv5USVw0meX5ezyry74VV3tBgNUy+C/CYS5QLHUmQ2F4a586goxzSiodovu3FzCmXMptE7pAQSW2tf1xZpr" +
            "t7+yMPiGwg5y4Rk9Q+OdQ9p2kDI30dCp2K/4WDmpUHLTc0Xh2A9ZsVAwnMcK3qK/Eo/QdafsW+QvAeYn/OeqYW9AUdZS/7HfaZOclup+" +
            "6qRB4y1Fc4nPhFVihue/P1mRPUza4HsgioQDELmkdJJ6k0jlLhGlb5Ogw2VWzdAQR7lyD/2g9Dvykkgu06KnDOxL9tnYJ6K+XpZEknQ+" +
            "VQvNhjp0hZVVUvjy+nJs5ll/TcxcVqVAGk7k9j/+eVPCptDJp5t/oMZqzLDIjJlqM=",
)

// Associates data and key index to a signature (algorithm: PSS with sha256)
private val dataSamplesSignatures = listOf(
    Pair(0, 0) to "xseloLIBcNJe2kJ95eGSj78zfi88DR8HT0lzkC/cSItZ4yphrgxcDSNca/NGrBRGHD/NY6wJjvhslu53glUEX5l+LeyCscZTKp" +
        "ag7vhztzt4Ce6Q78VEqec8T+4JEA79MSDgyemQC37tJ0hmN717Jpd63lT1UYGWWrR2edtcWxxDNEuxjVhp7igbkKU5EslKQsRSZJDZq+vFw9" +
        "7LN7YkS22R2WJJ+gOQyrsnCY4iS3+LMX5NZ3smfiZw3S1PiQQS2lSztLwYNvXjvQKwd9qK5yK9YbCvsAAHzKpul6FXHqJyxWDNUWHlPZdQaA" +
        "r896ATxMOgZAD6kVyCUSxYuuGB0w==",
    Pair(1, 0) to "yQMmEgCU4HDiZ1YPvptK3LTD83/IpIXN4t+M5t5GrbTbF3PdJFw1x64xCWExXROMLp2KoWaQcwxdITWrQqScij+euoKRueBGYB" +
        "Sp/hpDlIgkzgFemD+H15koVdSOijUXvPZzyFUay7tculQF9MIVRUHL+gDh0EVZ5UPBWK2vrtkuC+rC0g49FQZ9sG+vjE0E1+dI1QAfBTCDcE" +
        "81KHpXbLPAJccDAEtylS3+W4xojmaR6BvTNf/8igFSz3xg9AeTg8tNZ+cu4q7qR5MMguisq+YKfFPZo7JH7bV/8Ya0mM3qkY4Kd3MC5KiTAG" +
        "gx1NhxzPjshlhrBoQ92VghKfma1g==",
    Pair(2, 0) to "fQI2AbxMPx5MmftBRfOe8Vk3/nTAsLl+7l1D3wiMd18vSKp/AoEUKSmLcpduvkRScvQbJJRepdoMfOm/EFjzyQHCee1w8mjw42" +
        "ggoOt2G68Ktqm92etJzW6UkHDNzI6jJku8E2P+tO3x6iaWYRbJxax2o1TV0p6y8IM1sajdORHVskokeZu0vYuDRG4BOYlRwdphmZ+1iaExqM" +
        "v36794rDoyf1XEn9QfJu6bXSFh80A1iD9fi2oGSyr+smfkafZhieYoyvRxv43bkdaQpsWwpmN0OvNBs6Fa2/5UR7dPdaUpN2RHT9mYZJGV+c" +
        "fxWqvcbW3RZcrcYZuxmrwKDJZx3g==",
    Pair(3, 0) to "tk2p1HWxncYaHRIw7rqZsDJtIvUNNzvNQJgkn5qU3p2r2UjDWtWchHcsSRpOt2kp6cbQK59h7bvJTQTFDYU/to/JjASh0EdcWt" +
        "Uq6dS/FAw0slqLVu4mJlu5+JbHtq2a2do5HAccNE7K3ollivmmPC2/K3sqogxrb2X14GxETwIUE7hk3FQA+WV1pyulj/AyF41WM5t1ey3X3l" +
        "vkb878upH7I7JtwNcxHH0mqYsm7NOol1TF58NYv7a+FqJSnMlZ95GaXut4BxRT+u7Ul3AQqJYeXeebv04WWHcZXfhz3a6lVUSMOVs7v1hJNL" +
        "5EkHpeM5Dl2KsQKCW2lMpnSzIPNQ==",
    Pair(4, 0) to "AQrV8rzZxvEZRNECtpZIVftam2exo+wJWIDshhVsB5OTZOeAzRkPjwDfZ5piiuDBGICDcxYncwCe0k4mJtqMlnoCoB8yXqlVxQ" +
        "gQN8GkFgRR1Zf6Dc88ev2n/02OEYGuA+lF2kNtv3A+w3NAkk853PIWrjapbQnk+SvCRkRybhoZrVu6xWph+0x3ksSC44JHsrDMCqMqbXyvDI" +
        "RbS25HSNXky2/lDcwDwO4nUGDW6kJ0/KjK8WIXVbDERgjWBdMYyQ1/p3KavJuHayNoA4QOxqsqlzhDFp7+S568B6RAa/N22GvvTjbk2DECEE" +
        "kXrBJ4FCEG0Jja3mHMWGcFII7msA==",
    Pair(5, 0) to "lr/vcZqFYsVV5s4b5+ffVNTIU9PSsFYet2lyf1eM9PA+LKRGljVmTi/lI/FQL/uOoJAf87m/DpemCwfFoUzxiw5EDJAuVokTFF" +
        "6aqpDRBG0plhOKKyYLLPKc1p4MRBi44QFYgZflpKQ18cdlJ4Qvdlsd3INfZG32DysnLkcBGraGuaa/vdRMtW47cabYZJS20jsO5LFFyfnInw" +
        "YBVeM8rHDXwTUI+w+48yJusSgD2ykV+0WDrZJ9NugLYZCHu6RelvuYMJOmBmvfcVTlaDgpvdR8XgeVmOSPX/Hhqy6sFFy0GtaRU/GnnauzjV" +
        "y5lR4iYRymI0Vcbn6sE65w/rEG2g==",
    Pair(0, 1) to "QqlyjGrxbJrCGxwlZmb0mn0dlyIuhmjBUweKlxW3gZRAEKsruu7o6r+1C+XI4xp6bj4QVb7F5hkPe6WuZSa+zfJGirhZ3AUgxM" +
        "iv1q3mgbFK1Oo7VlZMtdrINwbsJ62PpbJ/htJcsjY3ZxoWR8E4g3J9o9KcCQyGzwT36KmPx+qqrBm2ydnWu6lqYijTCIHJBriK4c4SVEWzce" +
        "ezw9gNUCiJ7Z3TPI+PRHKyf3vG7SZoJ+xHjwqRD+Kud4SdVhcOBdp+36PXFm11Sa+cwiwSW9iLUaNu6dlbEroVfgoLNuiKmIJJhVDOtRXn4v" +
        "HsMEWqqmdlZ0srcwDF8W8yq5p8SFyR1ADqgRd2/EqVcFDZqvLdf4ZRSJHltJ49HojVk8rWH8ESLU2S5IKfeg/I5bPlfh0H0ZX9bzee0J6QVt" +
        "AbId6od6gAzGO56Rxlv3+w9rIxIDxxQfUqOmxgn8Q9/D30ORqCE5FjczPHLSyuIv7u2W999z9ExitHcLtlGcL7Is6TE7loB2vJIdwgWzRbco" +
        "2l7Yf3n19uQB5aqVwqa0+VwhcK43ZNd58acAbKNJarbruWlBzw9eooC1nHQKk//9XbBRW1/n9PoZARitnah+Wkc3xs1RMgyd8wAMEsstm0/L" +
        "w5+DK32eojYw7xZ3F0wvHRB8CkZjhVvqoqMTCLIk6ikpk=",
    Pair(1, 1) to "rSzgZ913ZvjXaxz+eqOMGuqr8bm92Vo0MdjlM41DFjfch9EUKC8vQvNwwsz0enWdOr80ySSGNLYIwoqfWnMf8EsNrPNUZPzxcX" +
        "PxbUuYplGK0oB9A9CDJ63xtQemGft9Tbv3HKw4/tY3jMxe6mVXte5P2EWXogmVBJPwgHadaI5vs5cGiIQ7JVmEbdJK5bpQxJMMBSrlShUwBw" +
        "rbFfhzPzqBnrFx4fSaPb7a95rpzRsQbFeghj5saatD+t8IykD6KjtquIWFntoIliaR4bft0MIihcYmkSf0K0a//cfsmXdQvQQfh0PwalXfuC" +
        "iF8vv+zhBC5zNaWiRdJb0f++PIMPOCB1V2pxKq037XqyLNGYmfT99c8qpOEYIhyVZoi7+R4l6qIUZSJWsKyZQCHgmJ5Ypjv1w1ZKAUPguWzb" +
        "DsrWcz1oQxtgxPjhOEbEjr2q6xZ1Ic+XvxD6cuCXuSmY0hshGs7orn6tymRY2qz1zgPXJ6oJPcYhdvRkm1sdAhOBinmkS8X6XEU8fw6iyLiv" +
        "hMlkYUiuAjOyVQL6C9/wfkZiMZimnBg6u3GY3L+V0mH+kx8BxkCBPRZDM+z25RtoS10RkhludIWWpG0BPoo4sJ0b+mOD171LvvaTeHaF6uEp" +
        "w82LwK+SKQb2B519z9lZfDYrArPswliykCmLerE3plRas=",
    Pair(2, 1) to "WFn8WZ/8EOs+qCHVBdUYLiOuvI5f7SFOTqKBSBcM1N6g+2wZ1W84/bXepivdl8hKtVlUXtKnpYlzidDBblBH6qnfKyFzeiLrZF" +
        "8TqCvXgm4c/tz2h/gM/exv3/DuZezvG592ZZrcjYss4kX24/aTIKJpCJ+aIwZISXQ+dn/kxIHiemmZ4rpW1+Hz1yxpYKacNg9w5SoDCFg7k6" +
        "kBaQV++QGZoLCUoxL59w0xV1mxMEq6n4hfscqWXdcwXpCNUAQOOkmnucmi1M7lumcvAMaCbrb9MSxTZXmjdPVqbSq9pPj7CjefQRZKVKJquT" +
        "TfQ0DLlk2nYMySB2e/CndXjxQMBM50OjxPh00OBJ7u6qnrPHcc9Ce31+I0tNgP32VcdB11/PzD/xUNfHMMHlbJ/9NsumupHxR6vgzKnGbWXI" +
        "xT5oaaa6u86QA4ezl7TJlf8yzf6Qaun6hehyCbMwjYp6/pjdenoe5ITSucBxf5r/4P7JdvHxli+VO3FmtDYLX1ajdhvK+A5SzzT7wmb5Qpdc" +
        "n3G/zLZFE6O+Fpxa48tFPhX6LY9L7uqTXGD55YAatqnqYUwCxvEKbN3m1kahQceK7AgXJkS7BAlxvSypFVaKMFENy2cob1UMfsUKmV+gNrtN" +
        "CNxS71JiZcrqkGOkUWOPsO/W6K0+JK7yyd6kmbeBUmtlU=",
    Pair(3, 1) to "PuysSeoeT8UpVTAaFRUCdn8p9l3YBBk86IGH9pz4dKSslx5MhbcHBVmJ2Izx1WrYXR7K8rjgAIhZg2wanuUzmZjX5/7o+naVh7" +
        "lBM4X3VO9lBVELi12v9xRneiYnfmqfh4WtXghCxyGIvu0VfcMilakK5RyIFvoQaHJucuMzpwlK6uWpUJ4VptDMgB2jCTkKzZok5QTpI0BJP+" +
        "yzsszNZ/hW5EgNHjNjfMR9YDHK2WOr6uKpX+lyx7ImiP6yp61jLWzE/iR+l0TTdTZabB6LfdYI71TdiOQ8UdDruS/VoffrMuCJECWIMbdq83" +
        "R8jr/9BrMTlKDh0bhL/qO03CyeZN5e7zURKQ+e/sde4b4zHdMRYLVxdvwBjBiwMAOK6S4+wGTu9TJIFL7azge6W6QirWvVfBQPS5hzfLK9KF" +
        "ZIBFke6BgK1HlzCBLlsZHl0XL7UCPVqO3jayH8a6BmuyHcANypZROBdLNKbKonovCyuiPt/vTTYwzBl7ndqs5jkr338bkmJpU/+OaOBJSEYr" +
        "HTR/UG4bJxRpy4pOVzzQZZgZLhf0LRcCDaae+2LSlyse8cFXf1ZhhlVa56zgfVFjyE1Cn9VKsN/cxzDSh/+AEp4nu3vp/8AAE8h+3N/3yuk0" +
        "SzheAti8avynv2YagBJL/dgpVgYw113MHp6UmdJiSm6q0=",
    Pair(4, 1) to "YmehOaCX2Qy/q5lDAyCBLA6dx3VmzrDVWW29KXX4XP7JMhPQSQSimPbiLCTQMRKaCC7u3sPX4c8ZsDMKpXURlAtVdwaYJGXkgV" +
        "GTnkhR89DLXSuVxgppg8jHj+xKHhXbFRYs7L76L0A95aD1miu7YA15Oli4SQO/o+Lh52kt28Ta8yeaIPt4lNQPcdUkxG8gQdTBjlIujIorZ2" +
        "ILg/saGpixsFBZXgJFjfanL/Zg/48MAw5+Xoph3BzYsSWAhJU+avOuq8JSjjykzX8AUN2/mv6GDjGNbLBhUYBQ3vQQuHhZeXNR503Ly1TCrE" +
        "gFNzzFEKxUhZDdTCKx/FLKDILDvBDLzMtl5ArHKbS4FM95xF6y9aVZxpi7SY6TTovJf8aQ1EIkwe9Jkt6aZrFdA77ZoNAP5AXKLEV9XoPH0g" +
        "KZeQ4HVf1Q6W8vNWoLA5iG1i8+26p8E9Xmgyw4wmw1ut8qrBz+BKAwdYkgDzoIYaei7XTqbWqy1qZhKph6WzW+UyUeS1Lr6Rx8tZ/7oCyV7z" +
        "88ytmEk4n69v+73x6qS1fhbdnh+FthHmB7YA1DOPZxCSajdDs0lgzSGPBi15AtfObTvUiUxAV1wIvcxEXmJZuxDdx4dQVXEmim+BYRbkOmOI" +
        "JEO8qeqLdCkiNd/B0xXt4XTDIjcNnRHlDFkKTG8JrBu0I=",
    Pair(5, 1) to "G6eqDeT8TmO6Cp8W1if30ylFkZW8KuY44L5IskGrsDGFz8/wiUlGWNVUF86wiJr/KBYT28q0mRNatpAwiD9CY0aa+r55bcZfFz" +
        "3U+8tNrpicdtVdor7dMjoF9/4ZVt6QPfroTFCWjYBmioxJregcxVmUf2mmpICqXRns6n+6NlbBu8IqksE5BYPxoRLI3qQawjX1x3G66SPlgj" +
        "Spfy3P0B1xNIXelR78Zr7/C2w8e4wkj0FOQh5emhjUkhPgIRJL51lniGFCH0cvf7ckg0QJaTK4IHmS8T2U1toSdSDn7jERUz6K4HJ+FalJtc" +
        "8Q03BZGJ8UvnEzfccM6vlHDEGZtr4GO7ZzG+PQZVRg/5deqrEsb5OkVo9WEB4i34dDJdt1bqih496k+KQEP6wrqA9oXIi0l1BlPUR1p0eqUu" +
        "acHrlOGxAZthUxLU9Pa7PH01v6WTFeQWX8S/Z+cT6Ez4miGv8ne2oXMJYQaikzaHiTrN0SoZs/GDV9o5mq7t7/ZYABARbyO+xqzgDixQkHeA" +
        "Lk9MXlWJLfx/SH6xCtk5NC3VXIcSvmyJxQiWinFc5stti2SPrCetveRqRuHn0Y4EknDgLNC3E2tohXGZBBjAdQCNzwatRDisgJs3o9yz2Nlt" +
        "zaKk/h3lwE7ibDjrbwzNqR8dzEoyPhJaLp0XJtEY48/Ls=",
)

class RsaCryptoServiceTest : StringSpec({
    fun List<String>.trimToKeySize(keySize: RsaCryptoService.KeySize, algorithm: RsaAlgorithm.RsaEncryptionAlgorithm) =
        map { it.take(keySize.maxEncryptionSizeBytes(algorithm)) }

    fun String.mutations(): List<String> = listOf(
        drop(1),
        dropLast(1),
        "x$this",
        "$this;",
        "@${this.drop(1)}",
        "${this.dropLast(1)}#"
    )

    "Service should be able to encrypt and decrypt data" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(OaepWithSha1, keySize)
            data.trimToKeySize(keySize, OaepWithSha1).forEach { d ->
                val encrypted = cryptoService.rsa.encrypt(OaepWithSha1, d.toByteArray(Charsets.UTF_8), keys.public)
                val decrypted = cryptoService.rsa.decrypt(OaepWithSha1, encrypted, keys.private)
                String(decrypted, charset = Charsets.UTF_8) shouldBe d
            }
        }
    }

    "Service should be able to sign and verify data" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(PssWithSha256, keySize)
            data.forEach { d ->
                val signature = cryptoService.rsa.sign(PssWithSha256, d.toByteArray(Charsets.UTF_8), keys.private)
                cryptoService.rsa.verifySignature(PssWithSha256, signature, d.toByteArray(Charsets.UTF_8), keys.public) shouldBe true
                d.mutations().forEach { w ->
                    cryptoService.rsa.verifySignature(PssWithSha256, signature, w.toByteArray(Charsets.UTF_8), keys.public) shouldBe false
                }
            }
        }
    }

    "Service should be able to use exported then re-imported keys" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(OaepWithSha1, keySize)
            val exportedPrivate = cryptoService.rsa.exportPrivateKeyPkcs8(keys.private)
            val exportedPublic = cryptoService.rsa.exportPublicKeySpki(keys.public)
            val reimportedKeys = cryptoService.rsa.loadKeyPairPkcs8(OaepWithSha1, exportedPrivate)
            val reimportedPublicOnly = cryptoService.rsa.loadPublicKeySpki(OaepWithSha1, exportedPublic)

            data.trimToKeySize(keySize, OaepWithSha1).forEach { d ->
                listOf(keys.public, reimportedKeys.public, reimportedPublicOnly).map { // Encrypt with each public key
                    cryptoService.rsa.encrypt(OaepWithSha1, d.toByteArray(Charsets.UTF_8), it)
                }.flatMap { encrypted -> // Decrypt with each private keys
                    listOf(keys.private, reimportedKeys.private).map {
                        cryptoService.rsa.decrypt(OaepWithSha1, encrypted, keys.private)
                    }
                }.forEach {  // Ensure content is valid
                    String(it, charset = Charsets.UTF_8) shouldBe d
                }
            }
        }
    }

    "Generated keys should have expected size" {
        // Checking size by verifying the maximum data size for encryption.
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(OaepWithSha1, keySize)
            val dataOverMax = Random.nextBytes(keySize.maxEncryptionSizeBytes(OaepWithSha1) + 1)
            val maxData = dataOverMax.sliceArray(0 until keySize.maxEncryptionSizeBytes(OaepWithSha1))
            cryptoService.rsa.encrypt(OaepWithSha1, maxData, keys.public)
            shouldThrowAny { cryptoService.rsa.encrypt(OaepWithSha1, dataOverMax, keys.public) }
        }
    }

    "Attempting to load invalid keys should result in an error" {
        RsaCryptoService.KeySize.values().forEach { keySize ->
            val keys = cryptoService.rsa.generateKeyPair(OaepWithSha1, keySize)
            val exportedPrivate = cryptoService.rsa.exportPrivateKeyPkcs8(keys.private)
            val exportedPublic = cryptoService.rsa.exportPublicKeySpki(keys.public)
            shouldThrowAny { cryptoService.rsa.loadKeyPairPkcs8(OaepWithSha1, exportedPublic) }
            shouldThrowAny { cryptoService.rsa.loadPublicKeySpki(OaepWithSha1, exportedPrivate) }
        }
    }

    "Decrypted data should match expected - test with data encrypted by other platforms" {
        val keyPairs = dataSamplesKeys.map {
            it.first to cryptoService.rsa.loadKeyPairPkcs8(OaepWithSha1, base64Decode(it.second))
        }
        dataSamplesEncrypted.forEach { (dataAndKeyIndices, encryptedData) ->
            val keySizeAndPair = keyPairs[dataAndKeyIndices.second]
            val expectedData = data[dataAndKeyIndices.first].take(keySizeAndPair.first.maxEncryptionSizeBytes(OaepWithSha1))
            val decrypted = cryptoService.rsa.decrypt(
                OaepWithSha1,
                base64Decode(encryptedData),
                keySizeAndPair.second.private
            )
            String(decrypted, charset = Charsets.UTF_8) shouldBe expectedData
        }
    }

    "Signature verification should match expected - test with data signed by other platforms" {
        val keyPairs = dataSamplesKeys.map {
            cryptoService.rsa.loadKeyPairPkcs8(PssWithSha256, base64Decode(it.second))
        }
        dataSamplesSignatures.forEach { (dataAndKeyIndices, signature) ->
            val keyPair = keyPairs[dataAndKeyIndices.second]
            cryptoService.rsa.verifySignature(
                PssWithSha256,
                base64Decode(signature),
                data[dataAndKeyIndices.first].toByteArray(Charsets.UTF_8),
                keyPair.public
            ) shouldBe true
        }
    }
})