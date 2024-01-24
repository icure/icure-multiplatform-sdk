package com.icure.sdk.crypto

/*
 * Loading data from files in js browser tests is hard, for simplicity we embed it in the code.
 */

val data = listOf(
    "Jojo",
    "Giovanni Giorgio",
    "Lorem ipsum dolor sit amet",
    "The quick brown fox jumps over the lazy dog",
    """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
    aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur
    sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.    
    """.trimIndent(),
    "Exactly 16 bytes"
)

// Sample rsa private keys in pkcs8 (to use only for testing purposes)
val sampleRsaKeys = listOf(
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