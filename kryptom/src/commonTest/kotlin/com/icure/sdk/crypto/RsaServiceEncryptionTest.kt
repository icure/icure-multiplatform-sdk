package com.icure.sdk.crypto

import com.icure.sdk.crypto.RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
import com.icure.sdk.crypto.RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
import com.icure.sdk.utils.base64Decode
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.String
import io.ktor.utils.io.core.toByteArray
import kotlin.random.Random

// Algorithm -> ((dataIndex, keyIndex) -> data[dataIndex] encrypted by sampleRsaKeys[keyIndex])
// Encryption done with the js implementation
private val dataSamplesEncrypted: Map<RsaAlgorithm.RsaEncryptionAlgorithm, List<Pair<Pair<Int, Int>, String>>> = mapOf(
    OaepWithSha1 to listOf(
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
    ),
    OaepWithSha256 to listOf(
        Pair(0, 0) to "AqA2ZpceOe5XKm3E52wgMhV4z0S75UoeL22p0g+1BAV5idCS/EIU2Zq0lQMVAuj2pOthNvSCU5Q3WmbmstogaXlorZeF13YS3M" +
                "hfnZDkriW4HXK20RhMq74eWF40qu6mPIftvrXcVZOBoZ6GtsFNbQtdggeRmGHX4x36AqC2orzfbQhZ8Y4X0JnDjXjP9i897lLH9i2bXd" +
                "T/+wNn13rQlamGoeJ61O1aqvChBR5FObytqOPJoB78FIl2jC619SIL7LOW6A8GqUQcA5osorRIG6znN0bAHQeS+x3gXQ8xnBIL9yMxXH" +
                "2tyHoU3jPgimoI3c15TbkcrSUB9RzU/ljt9A==",
        Pair(1, 0) to "st6rmVRRwQBTLX53s175x+m36S3AVCuEVbzozR8tnsw9m07OpYU+c3BbfQJ/63CXb7738uvlFBCYhGxANChEtEmYQ7AMBlkX+L" +
                "F0VPt3jeuOtU75jWo6qHPEGTHujsBjDf/v+xjVcNknlQ9jyysvDUdd1KGexMzv3Yc3z1TgWqiznmEQimO2kqD+xl9v0xMTc9BuEiMq/w" +
                "pnTKx/jH4sat5q067WIOyMr4gr77m/mZ05fORlH1Ja1/rs18vyO1cgG6VzoqhRgQWAOI7yEoQmy8H7eK5IXzCWChNBRS1o+uqbYQc1Ib" +
                "rYAnpCusZruLnHfS638xV50JVl8ajhYxlZRw==",
        Pair(2, 0) to "YSGVH0gBrBU/ZZegpotYBs4juxxyTUxhEnG7RqIHyLSFCmE3y29GZsFdY06jFe0Tb0YHhw5ZY1T6uE4J3f6uyaxjS/M5ovChnS" +
                "aflA4q45G35DFjUC61yBERMG2OHd1n2mNqvF23rIP0mWObR6vZQcPN8BNxAYM3hX7jmluUtGS9Hp/egT55zTZl+vAJl/SPuqkHIBGwnF" +
                "ACcMlKhY5kVhTErCj9cwTxFI4qqHrrO+KmaFLt3UltaEj76QKvEV3qRPuJulUvqWmsFYq1ctFsXusye83NTlI9bU//Y1yLhWXTWhtYfy" +
                "ulvWrQyVlUGDjbIMftqp/OHdUcvwNRDF0Jfg==",
        Pair(3, 0) to "PhzntAKwYoo5IvzcKqzaBwnGZPKfq5sjUL60U3skpdT75APUZbDcJazNQrl9vDriMXXnUAs/cplbqli4PvHeTlDfF820sSnm7g" +
                "jPvQw1sntmdoWJSauMQrQvBuWKExATOEyhgLKlEgYI7QTrZ/V1VMPHPsPJkvWdhnp4A9Umv4tf1DoZFuPkTQHVfeszEXdZ22Q3VOKTKf" +
                "nId9F2r25z5poWJ0nUZ8UzPbI1vsGK1ZtJKFyYPudFtcCyOmKzDCgBoRJ92GhAiCe9TohnaFB3hL3ZOVLcaoHCwLVk5q1P5vb+WZABl8" +
                "7UwILUsdKOqw0iRP7oBpUMeKlUro6O3BURCg==",
        Pair(4, 0) to "RryrigSku0igxhYAKshZZcS68X8JV2gsyI/0N/DfiAj/U7r8dhPDKqpN8zeqpbdWj/Ir4O5nkakdUFxRGVCkGXZUNLhWnXfHjC" +
                "LKfs5PL9YjDY0+DBI/DFL31Um+YjtlZG+JMMhsQ0SbJN8cwOSEHdzEYRm/xJHKfaV3WmZh9e6XxiCu8Xl+jlUUGsyhoInJKGsUw/5Xd5" +
                "6pK2aOGrgTiXIhwgSaLuEiR/HkkzTmhyAsN9VzAt6QSaHbb+orAu3ubg7wzquzE7k3FgZc9JlyiIwK//v13hYHwmr+ID9ZosSRGYO9z0" +
                "rJmi53HzH2U9qQekwdtQ8vwihWr+xO2H4kYA==",
        Pair(5, 0) to "0SDBHsg1+z7HE38niygrDrBaFc4SiY8W8PHaNCs3ABBePhy90LBEWoVrwjv8o+SttRRwazB09wxzu4a8SQnv9DeKjXVMHbjjL3" +
                "YtglTB54YrCxscwFJIBsUW29Y+yz2iUAs2ccidt34SwotIvaCGPJs4UPzLARdYrlFWj4EzFf1cY4HRwxjh7Bg+l52brbD++hdMDwDE1G" +
                "gOs8cy/t6Xd+e6nRyqOSYR6TKnjXDqBYdQMkHiQfzIjkwi2SNxomAr+k6rTQpMQFe4VeQA9geh29xrYRBKhROcxbpdyuOKd2ar/W0DJt" +
                "uRa2qpQWUEjCVBX+rLkmekeLrJThlyy3S6zg==",
        Pair(0, 1) to "RhZbrFi26oGUYso/NsdmYbdPfoNUN85DuXHLyoDEpQ4WTF4DOEVfKBuwBgp4hUkgMZeUSRRHrWSKmvU3qZm9VZnAevuxzBzwCF" +
                "n43kJELLL9A3jV/0W/kWmOhuFF1rhT7dvyFfQfVAXKhCHc9YEB1FfUAVVEuRmocBbnTkvEdsCAdwlOxrFNiqWfl9w+iCR8USaX/sNIlM" +
                "pHOgSPGn32Psk/A7iw563tGXInyIaMxehD6+iH9FnLCci1v8tmUT6RMYWWk9Qm6exeIccNRFyfzLr8EoagXF1k+OvXe/7roFmcOF4t1A" +
                "zej0OvsjV2l9BD61B5lMG4GNye45d5Xc3reiUjVIAYfSPWo/RV/PLtsNGkgK+biI9SZ76ttvAGMbCEdaLo5o5ul/N9P3o7gqI3vOMuxh" +
                "kY1sTiGwLfgE1ezA/aUVMpOO+H+lim+2ZPAkviq4rWtmlDFrydejfz/w6LjF1mFFbpWCqgsCZs79BSxky3GIRI++CBYGxosaslY4XVVv" +
                "mWassHan95o7IDV1MZXjOwqGE+waHPSguPeqDhmBhZbsVEd+uzHn8b5YH1xlFcF3N6/5pHSyVhgIts55XWIIzT44IaLcESCTlVFIydmV" +
                "6JNbUu6VDBDVap7UXOaANSOmgLTNi5UD5Tgi5hPLG1GxBKxQUZ4iOMd082NZyaL7I=",
        Pair(1, 1) to "hunObhQjgHumHoCbpe5WCb8Gc6wWOLbjaIUbCDMLZCHOsGdy31dp0OZ+55elbVWMSAdESkbyBM+DrER2ysUXMSpWZHDAp5lIrL" +
                "PaFimVGtoypTQVhJeE16t37e9NkZHb+AKcgpQ8RxTuklPYhs7WubNiYsRoQypiPO6DPu2igzfWbhDhPvH2/QwIIITrHFOjBFBQ5pRNzp" +
                "fWjS6yfGhW3K8RFReQBVpFKcN0MWgjtR9veT/Er5DnhoNOwN8MLjdXVZDoPc3hLLLRcgiH3xtg8unt85eh85kvdGiYjGs1rb+lsEoE3A" +
                "ftD7vQpVRdgLnkh/K4KlzdtGKFftzAIlfYizSYuawCef5CVFFmKTn2eSbGKGQGqcyqqt8kTM50Y7H2x0/iSoQfqz1UzRIiVENeCh0Fpx" +
                "XPRA/06BhL59rga/nT5PyMa0gjITQLWZIxOhy2TBc3qtMSK1Vx0H7EQLCp2mT9YF0mJtkoYBQeuwqt8Caqwsu3wR3lmmeN4mbiJMYfzM" +
                "ptnkUt76owxB52gW2jVylrIPlpL6IQjNVfOHxzERA8zh1DBbNLIdJM+XUZb2M6joWOEqZya553zQ7u72m2+7rWbQ5Wrm8t6isGNUSiKo" +
                "4IvUyPfuxztQLdO2uZX0NDRwY/TueEZGOC17xzjdkiRL9RR/1PQSdnTNG1DyjXvNY=",
        Pair(2, 1) to "IIxDrO/HE0Mhq487mDdlQAtGZ8StwUkGgrQp3S4fG+ndJFd2jZ+xm09mPqJyrxOvFvbGiNIKTb2EGXQw57SEGY+HZQuzqLZa35" +
                "UHq0RBgznPvXJAOo0sGuA290VPkHaG9RTuDEh3iC5G+diiKQTmVl/3KiNdMIvewg84you9MEq5kjpOpAix9g7RTrmUzr0iXR50F5e+DK" +
                "QMdgckUjThNTqHpTXmBbH6S/TMiQr6yPy1ng304RR0KxQjki17glZcz7hSNibNb1VrGyFJPDSiMm6nY/NrdPaje4hzsy3krWFHIiIw5j" +
                "ksuaCMG4a+4c2fpT2hgeIwIBX3gp/av3RhotY2zFBqYq3n6BrmemgufHdDt7n0Nw8EHdhZumd2GV8UaoSxtpsuwYI8AGMrJwvXaD3lQ6" +
                "CZ/QFgLJJAZ6rPqpfiNm+pjUjS2iOVUWTOrhQYhjspbqLzCdi3cfplhYa0u3E+B/Q0gK3PHuxNZvHqNgjP+aUlJKjVgUDA5J/BvceDpC" +
                "YGprwcJYCx9YPtDiD0mg1jQFc60LBRTha+BTWK6N6o9N2tMBq0cjJiHubLtTxGCMiIaiUQfvJ0CXFpdY5EphTk1cliN03+5a8kb3bLLl" +
                "mnDLWHHDEyScoeg7puHew9XSamZySKDadLMixBa5QCMW8jIROgFR6BzPVjwVx+Gpw=",
        Pair(3, 1) to "OWJX5ZmZb8egfZqz/TinvfkQ4z+ZxORrrUzARbnQBUWaIl8ezew9o4w4Kd7KwpiNkiZlJIK2reN1Absn27rg6xAdtYplDoN1wo" +
                "ajYUsRmjFd3/a9TUbwWtih+4AzkTj5pZZcinwYVgEpYs2ummeJJZXIbPQdQi1jIOB11aErjngs5puHUzXoligTESfOY7hMkffzzA+WZR" +
                "R6X6xgRK3rB6tWpkAfuEbbInOQIg/JsuuOI1bEcmRQ3StorA06AQCd81kf/uCb565cDjMN8lNoR83NIJ+sFjQPVMzKTY8IpVn4BbecDV" +
                "VDhlwctMlUooAqifT2tS4apNi/1SjUhh+IzG8i0wMoC+OwEcoYb5s4LN9wqBSfjUbeN+BU0pJSTAOIm13gJiKUk22cwoSU3DQv/JIF/P" +
                "8hBTwiy2rm3DeSJEvRxKWLbNVX1xDvQqifx8fwuKRw6oOHQ+ipzJp4ciwCqkDaY0buTaD/OGvx42W7dRotIuPS5lBhYTV7sqBAI+qN53" +
                "7MI2k0XeFx6jUnHibX0NFHDoqCtjnq6izBzutT7cDFfQRAru7bY9VNU/FiZF1f+SYAo+6CUldpZ3UkrCg+fCTrCx6eCg+0HkLXoOyyM6" +
                "inMaye9vL9fTyDoNw44qJECFD2ZRNxp3bbT85q8L4WkvU5XRkjl4T3zseCohkkavo=",
        Pair(4, 1) to "cjyvs2bR1HHh6SR+buUO9JUMdu2Zgv2PpPnSiNXDGv2Ce7OyuW9i7MK83sAe/UgqzKDtcBOlv+YsjAJ2VUiYdXTVLl+Ja2QsE5" +
                "0J2hbVydut50U4ye1pZwFJaHdl2BWoGLLUtRjCING52VVd7MJciY18Nb+JXRnxjKkKSiT36uOKZ6GE99FBJDUI4z6AadCRgrQOM91SMZ" +
                "WELagrPCBAiO6+UIdHxAzHHn6RhFrtR/Blu2xbMryUTutG1KzzO8XGRCY3pr81UqfId7yrxiSw7ZDwWRlO0VU5MNq2cFnX45QPqnXJQj" +
                "lE5ovFH2jMAF+VFh7jRH8+LDXj9pFh3l3qrU2dYhLuflpqWKKFsasOE6JD6mrfII6ML6pAZgFY6guyRXunfqeCNb6EBFIB59FT7Mm9Ly" +
                "lRe6LEpxl0jvPDEoS6ARIkdUr2yoOpJZgzkY5cnuOsyCmGAnewdB//Eg0/cgeKfqIeRil8wjNdn327mCGF6lRZWmbIpTeIp/2xyLAqE9" +
                "k2S53EQKA3ld+aJGUaqc/ER9egNfgbJwp7Dtj4Sx2wDjJvn0Y9z1HjmHgGxKh64vCVU4B+JwCK1XdLSGUlqWMc2nAvZCIy3V4y7hPm7E" +
                "NwcA8I+9XJnOY5isay0MV4VDAJnUff3GBUA0H/Rv+/pujgnd/rzxoQB01VfClbWbQ=",
        Pair(5, 1) to "lAAg2TTxGeCczr/E3C4DvllK2aq9GzSnSAvJqtRJ8Zjkhi82qSnMUg3IbEfyD3cMYlG482O17qVEWtIwbVD4xJI1XUj8QSMNsM" +
                "vf2Uu2VwihJY5jGhEKsxzzr05BG7BEwSMrVPYgfWl6sNHFkbIESRODbPt8MXGIX4BlecK4EpIAHeJrdl1YpKhi9qoVE5mwGGFqojFJXu" +
                "9d8U3rpxriZgirSVySyxTzAQdqoW+44O77Od4ZKghZsCizewZBr62xeZIdQxwjfQUKCoSUIK01yP1Z75xIAal4AHlAKpmYVFonsx1TX+" +
                "WlzkXcN76dxMuG6KTKF99BnexFuzlcZnaK1agtzIU8Rg4Yb8VDP79fNgu69RtvZofBQnPUQRAg78v50vKmUcnOB8vDPOt8xyLuSG2lIF" +
                "qwPzOWwez0CU0fQg5vlVuz5KPbZDhw4XrnBsty5h1EAUceTOXe8q899yInyYgjyQy0Mza9uKNE3oUBCct5nKmcB3nE6auTqSs1QdaA1Y" +
                "nXk8K7xXSFeqAD8XLLy/gE5lqPaV6BoDW/JTeeAc6lLtfMgqkN7TEh9t0kWAftibIY+gibxb1ETJIgNc5hIdZ3L5hcaglmjoasXdnGCo" +
                "X0IsFH1LLPZwWrJmVHMHhtS2uDpTIzXJHgT6kmLnss/LPrBe+GyM2R+KDYqqcUCM8=",
    )
)

class RsaServiceEncryptionTest : StringSpec({
    fun List<String>.trimToKeySize(keySize: RsaService.KeySize, algorithm: RsaAlgorithm.RsaEncryptionAlgorithm) =
        map { it.take(keySize.maxEncryptionSizeBytes(algorithm)) }

    fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> doEncryptionTestsByAlgorithm(encryptionAlgorithm: A) {
        "$encryptionAlgorithm - Service should be able to encrypt and decrypt data" {
            RsaService.KeySize.entries.forEach { keySize ->
                val keys = cryptoService.rsa.generateKeyPair(encryptionAlgorithm, keySize)
                data.trimToKeySize(keySize, encryptionAlgorithm).forEach { d ->
                    val encrypted = cryptoService.rsa.encrypt(encryptionAlgorithm, d.toByteArray(Charsets.UTF_8), keys.public)
                    val decrypted = cryptoService.rsa.decrypt(encryptionAlgorithm, encrypted, keys.private)
                    String(decrypted, charset = Charsets.UTF_8) shouldBe d
                }
            }
        }

        "$encryptionAlgorithm - Service should be able to use exported then re-imported keys for encryption" {
            RsaService.KeySize.entries.forEach { keySize ->
                val keys = cryptoService.rsa.generateKeyPair(encryptionAlgorithm, keySize)
                val exportedPrivate = cryptoService.rsa.exportPrivateKeyPkcs8(keys.private)
                val exportedPublic = cryptoService.rsa.exportPublicKeySpki(keys.public)
                val reimportedKeys = cryptoService.rsa.loadKeyPairPkcs8(encryptionAlgorithm, exportedPrivate)
                val reimportedPublicOnly = cryptoService.rsa.loadPublicKeySpki(encryptionAlgorithm, exportedPublic)

                data.trimToKeySize(keySize, encryptionAlgorithm).forEach { d ->
                    listOf(keys.public, reimportedKeys.public, reimportedPublicOnly).map { // Encrypt with each public key
                        cryptoService.rsa.encrypt(encryptionAlgorithm, d.toByteArray(Charsets.UTF_8), it)
                    }.flatMap { encrypted -> // Decrypt with each private keys
                        listOf(keys.private, reimportedKeys.private).map {
                            cryptoService.rsa.decrypt(encryptionAlgorithm, encrypted, keys.private)
                        }
                    }.forEach {  // Ensure content is valid
                        String(it, charset = Charsets.UTF_8) shouldBe d
                    }
                }
            }
        }

        "$encryptionAlgorithm - Generated encryption keys should have expected size" {
            // Checking size by verifying the maximum data size for encryption.
            RsaService.KeySize.entries.forEach { keySize ->
                val keys = cryptoService.rsa.generateKeyPair(encryptionAlgorithm, keySize)
                val dataOverMax = Random.nextBytes(keySize.maxEncryptionSizeBytes(encryptionAlgorithm) + 1)
                val maxData = dataOverMax.sliceArray(0 until keySize.maxEncryptionSizeBytes(encryptionAlgorithm))
                cryptoService.rsa.encrypt(encryptionAlgorithm, maxData, keys.public)
                shouldThrowAny { cryptoService.rsa.encrypt(encryptionAlgorithm, dataOverMax, keys.public) }
            }
        }

        "$encryptionAlgorithm - Attempting to load invalid keys should result in an error" {
            RsaService.KeySize.entries.forEach { keySize ->
                val keys = cryptoService.rsa.generateKeyPair(encryptionAlgorithm, keySize)
                val exportedPrivate = cryptoService.rsa.exportPrivateKeyPkcs8(keys.private)
                val exportedPublic = cryptoService.rsa.exportPublicKeySpki(keys.public)
                shouldThrowAny { cryptoService.rsa.loadKeyPairPkcs8(encryptionAlgorithm, exportedPublic) }
                shouldThrowAny { cryptoService.rsa.loadPublicKeySpki(encryptionAlgorithm, exportedPrivate) }
            }
        }

        "$encryptionAlgorithm - Decrypted data should match expected - test with data encrypted by other platforms" {
            val keyPairs = sampleRsaKeys.map {
                it.first to cryptoService.rsa.loadKeyPairPkcs8(encryptionAlgorithm, base64Decode(it.second))
            }
            dataSamplesEncrypted.getValue(encryptionAlgorithm).forEach { (dataAndKeyIndices, encryptedData) ->
                val keySizeAndPair = keyPairs[dataAndKeyIndices.second]
                val expectedData = data[dataAndKeyIndices.first].take(keySizeAndPair.first.maxEncryptionSizeBytes(encryptionAlgorithm))
                val decrypted = cryptoService.rsa.decrypt(
                    encryptionAlgorithm,
                    base64Decode(encryptedData),
                    keySizeAndPair.second.private
                )
                String(decrypted, charset = Charsets.UTF_8) shouldBe expectedData
            }
        }
    }

    doEncryptionTestsByAlgorithm(OaepWithSha1)
    doEncryptionTestsByAlgorithm(OaepWithSha256)
    /*
    "Write samples" {
        val keyPairs = sampleRsaKeys.map {
            it.first to cryptoService.rsa.loadKeyPairPkcs8(OaepWithSha256, base64Decode(it.second))
        }
        data.forEachIndexed { dataIndex, d ->
            keyPairs.forEachIndexed { keyIndex, k ->
                val keySizeAndPair = keyPairs[keyIndex]
                val trimmedData = d.take(keySizeAndPair.first.maxEncryptionSizeBytes(OaepWithSha256))
                val encrypted = cryptoService.rsa.encrypt(
                    OaepWithSha256,
                    trimmedData.toByteArray(Charsets.UTF_8),
                    keySizeAndPair.second.public
                )
                println("Pair($dataIndex, $keyIndex) to \"${base64Encode(encrypted)}\",")
            }
        }
    }

     */
})