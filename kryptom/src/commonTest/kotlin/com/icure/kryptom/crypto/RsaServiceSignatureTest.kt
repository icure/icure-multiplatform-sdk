package com.icure.kryptom.crypto

import com.icure.kryptom.crypto.RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256
import com.icure.kryptom.utils.base64Decode
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray

// Algorithm -> ((dataIndex, keyIndex) -> data[dataIndex] encrypted by sampleRsaKeys[keyIndex])
// Signature done with the js implementation
private val dataSamplesSignatures: Map<RsaAlgorithm.RsaSignatureAlgorithm, List<Pair<Pair<Int, Int>, String>>> = mapOf(
	PssWithSha256 to listOf(
		Pair(0, 0) to "xseloLIBcNJe2kJ95eGSj78zfi88DR8HT0lzkC/cSItZ4yphrgxcDSNca/NGrBRGHD/NY6wJjvhslu53glUEX5l+LeyCsc" +
			"ZTKpag7vhztzt4Ce6Q78VEqec8T+4JEA79MSDgyemQC37tJ0hmN717Jpd63lT1UYGWWrR2edtcWxxDNEuxjVhp7igbkKU5EslKQsRSZJ" +
			"DZq+vFw97LN7YkS22R2WJJ+gOQyrsnCY4iS3+LMX5NZ3smfiZw3S1PiQQS2lSztLwYNvXjvQKwd9qK5yK9YbCvsAAHzKpul6FXHqJyxW" +
			"DNUWHlPZdQaAr896ATxMOgZAD6kVyCUSxYuuGB0w==",
		Pair(1, 0) to "yQMmEgCU4HDiZ1YPvptK3LTD83/IpIXN4t+M5t5GrbTbF3PdJFw1x64xCWExXROMLp2KoWaQcwxdITWrQqScij+euoKRue" +
			"BGYBSp/hpDlIgkzgFemD+H15koVdSOijUXvPZzyFUay7tculQF9MIVRUHL+gDh0EVZ5UPBWK2vrtkuC+rC0g49FQZ9sG+vjE0E1+dI1Q" +
			"AfBTCDcE81KHpXbLPAJccDAEtylS3+W4xojmaR6BvTNf/8igFSz3xg9AeTg8tNZ+cu4q7qR5MMguisq+YKfFPZo7JH7bV/8Ya0mM3qkY" +
			"4Kd3MC5KiTAGgx1NhxzPjshlhrBoQ92VghKfma1g==",
		Pair(2, 0) to "fQI2AbxMPx5MmftBRfOe8Vk3/nTAsLl+7l1D3wiMd18vSKp/AoEUKSmLcpduvkRScvQbJJRepdoMfOm/EFjzyQHCee1w8m" +
			"jw42ggoOt2G68Ktqm92etJzW6UkHDNzI6jJku8E2P+tO3x6iaWYRbJxax2o1TV0p6y8IM1sajdORHVskokeZu0vYuDRG4BOYlRwdphmZ" +
			"+1iaExqMv36794rDoyf1XEn9QfJu6bXSFh80A1iD9fi2oGSyr+smfkafZhieYoyvRxv43bkdaQpsWwpmN0OvNBs6Fa2/5UR7dPdaUpN2" +
			"RHT9mYZJGV+cfxWqvcbW3RZcrcYZuxmrwKDJZx3g==",
		Pair(3, 0) to "tk2p1HWxncYaHRIw7rqZsDJtIvUNNzvNQJgkn5qU3p2r2UjDWtWchHcsSRpOt2kp6cbQK59h7bvJTQTFDYU/to/JjASh0E" +
			"dcWtUq6dS/FAw0slqLVu4mJlu5+JbHtq2a2do5HAccNE7K3ollivmmPC2/K3sqogxrb2X14GxETwIUE7hk3FQA+WV1pyulj/AyF41WM5" +
			"t1ey3X3lvkb878upH7I7JtwNcxHH0mqYsm7NOol1TF58NYv7a+FqJSnMlZ95GaXut4BxRT+u7Ul3AQqJYeXeebv04WWHcZXfhz3a6lVU" +
			"SMOVs7v1hJNL5EkHpeM5Dl2KsQKCW2lMpnSzIPNQ==",
		Pair(4, 0) to "AQrV8rzZxvEZRNECtpZIVftam2exo+wJWIDshhVsB5OTZOeAzRkPjwDfZ5piiuDBGICDcxYncwCe0k4mJtqMlnoCoB8yXq" +
			"lVxQgQN8GkFgRR1Zf6Dc88ev2n/02OEYGuA+lF2kNtv3A+w3NAkk853PIWrjapbQnk+SvCRkRybhoZrVu6xWph+0x3ksSC44JHsrDMCq" +
			"MqbXyvDIRbS25HSNXky2/lDcwDwO4nUGDW6kJ0/KjK8WIXVbDERgjWBdMYyQ1/p3KavJuHayNoA4QOxqsqlzhDFp7+S568B6RAa/N22G" +
			"vvTjbk2DECEEkXrBJ4FCEG0Jja3mHMWGcFII7msA==",
		Pair(5, 0) to "lr/vcZqFYsVV5s4b5+ffVNTIU9PSsFYet2lyf1eM9PA+LKRGljVmTi/lI/FQL/uOoJAf87m/DpemCwfFoUzxiw5EDJAuVo" +
			"kTFF6aqpDRBG0plhOKKyYLLPKc1p4MRBi44QFYgZflpKQ18cdlJ4Qvdlsd3INfZG32DysnLkcBGraGuaa/vdRMtW47cabYZJS20jsO5L" +
			"FFyfnInwYBVeM8rHDXwTUI+w+48yJusSgD2ykV+0WDrZJ9NugLYZCHu6RelvuYMJOmBmvfcVTlaDgpvdR8XgeVmOSPX/Hhqy6sFFy0Gt" +
			"aRU/GnnauzjVy5lR4iYRymI0Vcbn6sE65w/rEG2g==",
		Pair(0, 1) to "QqlyjGrxbJrCGxwlZmb0mn0dlyIuhmjBUweKlxW3gZRAEKsruu7o6r+1C+XI4xp6bj4QVb7F5hkPe6WuZSa+zfJGirhZ3A" +
			"UgxMiv1q3mgbFK1Oo7VlZMtdrINwbsJ62PpbJ/htJcsjY3ZxoWR8E4g3J9o9KcCQyGzwT36KmPx+qqrBm2ydnWu6lqYijTCIHJBriK4c" +
			"4SVEWzceezw9gNUCiJ7Z3TPI+PRHKyf3vG7SZoJ+xHjwqRD+Kud4SdVhcOBdp+36PXFm11Sa+cwiwSW9iLUaNu6dlbEroVfgoLNuiKmI" +
			"JJhVDOtRXn4vHsMEWqqmdlZ0srcwDF8W8yq5p8SFyR1ADqgRd2/EqVcFDZqvLdf4ZRSJHltJ49HojVk8rWH8ESLU2S5IKfeg/I5bPlfh" +
			"0H0ZX9bzee0J6QVtAbId6od6gAzGO56Rxlv3+w9rIxIDxxQfUqOmxgn8Q9/D30ORqCE5FjczPHLSyuIv7u2W999z9ExitHcLtlGcL7Is" +
			"6TE7loB2vJIdwgWzRbco2l7Yf3n19uQB5aqVwqa0+VwhcK43ZNd58acAbKNJarbruWlBzw9eooC1nHQKk//9XbBRW1/n9PoZARitnah+" +
			"Wkc3xs1RMgyd8wAMEsstm0/Lw5+DK32eojYw7xZ3F0wvHRB8CkZjhVvqoqMTCLIk6ikpk=",
		Pair(1, 1) to "rSzgZ913ZvjXaxz+eqOMGuqr8bm92Vo0MdjlM41DFjfch9EUKC8vQvNwwsz0enWdOr80ySSGNLYIwoqfWnMf8EsNrPNUZP" +
			"zxcXPxbUuYplGK0oB9A9CDJ63xtQemGft9Tbv3HKw4/tY3jMxe6mVXte5P2EWXogmVBJPwgHadaI5vs5cGiIQ7JVmEbdJK5bpQxJMMBS" +
			"rlShUwBwrbFfhzPzqBnrFx4fSaPb7a95rpzRsQbFeghj5saatD+t8IykD6KjtquIWFntoIliaR4bft0MIihcYmkSf0K0a//cfsmXdQvQ" +
			"Qfh0PwalXfuCiF8vv+zhBC5zNaWiRdJb0f++PIMPOCB1V2pxKq037XqyLNGYmfT99c8qpOEYIhyVZoi7+R4l6qIUZSJWsKyZQCHgmJ5Y" +
			"pjv1w1ZKAUPguWzbDsrWcz1oQxtgxPjhOEbEjr2q6xZ1Ic+XvxD6cuCXuSmY0hshGs7orn6tymRY2qz1zgPXJ6oJPcYhdvRkm1sdAhOB" +
			"inmkS8X6XEU8fw6iyLivhMlkYUiuAjOyVQL6C9/wfkZiMZimnBg6u3GY3L+V0mH+kx8BxkCBPRZDM+z25RtoS10RkhludIWWpG0BPoo4" +
			"sJ0b+mOD171LvvaTeHaF6uEpw82LwK+SKQb2B519z9lZfDYrArPswliykCmLerE3plRas=",
		Pair(2, 1) to "WFn8WZ/8EOs+qCHVBdUYLiOuvI5f7SFOTqKBSBcM1N6g+2wZ1W84/bXepivdl8hKtVlUXtKnpYlzidDBblBH6qnfKyFzei" +
			"LrZF8TqCvXgm4c/tz2h/gM/exv3/DuZezvG592ZZrcjYss4kX24/aTIKJpCJ+aIwZISXQ+dn/kxIHiemmZ4rpW1+Hz1yxpYKacNg9w5S" +
			"oDCFg7k6kBaQV++QGZoLCUoxL59w0xV1mxMEq6n4hfscqWXdcwXpCNUAQOOkmnucmi1M7lumcvAMaCbrb9MSxTZXmjdPVqbSq9pPj7Cj" +
			"efQRZKVKJquTTfQ0DLlk2nYMySB2e/CndXjxQMBM50OjxPh00OBJ7u6qnrPHcc9Ce31+I0tNgP32VcdB11/PzD/xUNfHMMHlbJ/9Nsum" +
			"upHxR6vgzKnGbWXIxT5oaaa6u86QA4ezl7TJlf8yzf6Qaun6hehyCbMwjYp6/pjdenoe5ITSucBxf5r/4P7JdvHxli+VO3FmtDYLX1aj" +
			"dhvK+A5SzzT7wmb5Qpdcn3G/zLZFE6O+Fpxa48tFPhX6LY9L7uqTXGD55YAatqnqYUwCxvEKbN3m1kahQceK7AgXJkS7BAlxvSypFVaK" +
			"MFENy2cob1UMfsUKmV+gNrtNCNxS71JiZcrqkGOkUWOPsO/W6K0+JK7yyd6kmbeBUmtlU=",
		Pair(3, 1) to "PuysSeoeT8UpVTAaFRUCdn8p9l3YBBk86IGH9pz4dKSslx5MhbcHBVmJ2Izx1WrYXR7K8rjgAIhZg2wanuUzmZjX5/7o+n" +
			"aVh7lBM4X3VO9lBVELi12v9xRneiYnfmqfh4WtXghCxyGIvu0VfcMilakK5RyIFvoQaHJucuMzpwlK6uWpUJ4VptDMgB2jCTkKzZok5Q" +
			"TpI0BJP+yzsszNZ/hW5EgNHjNjfMR9YDHK2WOr6uKpX+lyx7ImiP6yp61jLWzE/iR+l0TTdTZabB6LfdYI71TdiOQ8UdDruS/VoffrMu" +
			"CJECWIMbdq83R8jr/9BrMTlKDh0bhL/qO03CyeZN5e7zURKQ+e/sde4b4zHdMRYLVxdvwBjBiwMAOK6S4+wGTu9TJIFL7azge6W6QirW" +
			"vVfBQPS5hzfLK9KFZIBFke6BgK1HlzCBLlsZHl0XL7UCPVqO3jayH8a6BmuyHcANypZROBdLNKbKonovCyuiPt/vTTYwzBl7ndqs5jkr" +
			"338bkmJpU/+OaOBJSEYrHTR/UG4bJxRpy4pOVzzQZZgZLhf0LRcCDaae+2LSlyse8cFXf1ZhhlVa56zgfVFjyE1Cn9VKsN/cxzDSh/+A" +
			"Ep4nu3vp/8AAE8h+3N/3yuk0SzheAti8avynv2YagBJL/dgpVgYw113MHp6UmdJiSm6q0=",
		Pair(4, 1) to "YmehOaCX2Qy/q5lDAyCBLA6dx3VmzrDVWW29KXX4XP7JMhPQSQSimPbiLCTQMRKaCC7u3sPX4c8ZsDMKpXURlAtVdwaYJG" +
			"XkgVGTnkhR89DLXSuVxgppg8jHj+xKHhXbFRYs7L76L0A95aD1miu7YA15Oli4SQO/o+Lh52kt28Ta8yeaIPt4lNQPcdUkxG8gQdTBjl" +
			"IujIorZ2ILg/saGpixsFBZXgJFjfanL/Zg/48MAw5+Xoph3BzYsSWAhJU+avOuq8JSjjykzX8AUN2/mv6GDjGNbLBhUYBQ3vQQuHhZeX" +
			"NR503Ly1TCrEgFNzzFEKxUhZDdTCKx/FLKDILDvBDLzMtl5ArHKbS4FM95xF6y9aVZxpi7SY6TTovJf8aQ1EIkwe9Jkt6aZrFdA77ZoN" +
			"AP5AXKLEV9XoPH0gKZeQ4HVf1Q6W8vNWoLA5iG1i8+26p8E9Xmgyw4wmw1ut8qrBz+BKAwdYkgDzoIYaei7XTqbWqy1qZhKph6WzW+Uy" +
			"UeS1Lr6Rx8tZ/7oCyV7z88ytmEk4n69v+73x6qS1fhbdnh+FthHmB7YA1DOPZxCSajdDs0lgzSGPBi15AtfObTvUiUxAV1wIvcxEXmJZ" +
			"uxDdx4dQVXEmim+BYRbkOmOIJEO8qeqLdCkiNd/B0xXt4XTDIjcNnRHlDFkKTG8JrBu0I=",
		Pair(5, 1) to "G6eqDeT8TmO6Cp8W1if30ylFkZW8KuY44L5IskGrsDGFz8/wiUlGWNVUF86wiJr/KBYT28q0mRNatpAwiD9CY0aa+r55bc" +
			"ZfFz3U+8tNrpicdtVdor7dMjoF9/4ZVt6QPfroTFCWjYBmioxJregcxVmUf2mmpICqXRns6n+6NlbBu8IqksE5BYPxoRLI3qQawjX1x3" +
			"G66SPlgjSpfy3P0B1xNIXelR78Zr7/C2w8e4wkj0FOQh5emhjUkhPgIRJL51lniGFCH0cvf7ckg0QJaTK4IHmS8T2U1toSdSDn7jERUz" +
			"6K4HJ+FalJtc8Q03BZGJ8UvnEzfccM6vlHDEGZtr4GO7ZzG+PQZVRg/5deqrEsb5OkVo9WEB4i34dDJdt1bqih496k+KQEP6wrqA9oXI" +
			"i0l1BlPUR1p0eqUuacHrlOGxAZthUxLU9Pa7PH01v6WTFeQWX8S/Z+cT6Ez4miGv8ne2oXMJYQaikzaHiTrN0SoZs/GDV9o5mq7t7/ZY" +
			"ABARbyO+xqzgDixQkHeALk9MXlWJLfx/SH6xCtk5NC3VXIcSvmyJxQiWinFc5stti2SPrCetveRqRuHn0Y4EknDgLNC3E2tohXGZBBjA" +
			"dQCNzwatRDisgJs3o9yz2NltzaKk/h3lwE7ibDjrbwzNqR8dzEoyPhJaLp0XJtEY48/Ls=",
	)
)

class RsaServiceSignatureTest : StringSpec({
	fun <A : RsaAlgorithm.RsaSignatureAlgorithm> doSignatureTestsByAlgorithm(signatureAlgorithm: A) {
		"$signatureAlgorithm - Service should be able to sign and verify data" {
			RsaService.KeySize.entries.forEach { keySize ->
				val keys = defaultCryptoService.rsa.generateKeyPair(
					signatureAlgorithm, keySize
				)
				data.forEach { d ->
					val signature = defaultCryptoService.rsa.sign(d.toByteArray(Charsets.UTF_8), keys.private)
					defaultCryptoService.rsa.verifySignature(
						signature,
						d.toByteArray(Charsets.UTF_8),
						keys.public
					) shouldBe true
					d.mutations().forEach { w ->
						defaultCryptoService.rsa.verifySignature(
							signature,
							w.toByteArray(Charsets.UTF_8),
							keys.public
						) shouldBe false
					}
				}
			}
		}

		"$signatureAlgorithm - Signature verification should match expected - test with data signed by other platforms" {
			val keyPairs = sampleRsaKeys.map {
				defaultCryptoService.rsa.loadKeyPairPkcs8(
					signatureAlgorithm, base64Decode(it.second)
				)
			}
			dataSamplesSignatures.getValue(signatureAlgorithm).forEach { (dataAndKeyIndices, signature) ->
				val keyPair = keyPairs[dataAndKeyIndices.second]
				defaultCryptoService.rsa.verifySignature(
					base64Decode(signature),
					data[dataAndKeyIndices.first].toByteArray(Charsets.UTF_8),
					keyPair.public
				) shouldBe true
			}
		}

		"$signatureAlgorithm - import/export of keys in jwk should work as expected" {
			sampleRsaKeys.zip(sampleRsaKeysJwk(signatureAlgorithm)).forEach { testData ->
				val privateKeyPkcs8 = base64Decode(testData.first.second)
				val privateKeyJwk = testData.second.second
				val publicKeyJwk = testData.second.second.extractPublic()
				val loadedPairFromPkcs8 = defaultCryptoService.rsa.loadKeyPairPkcs8(signatureAlgorithm, privateKeyPkcs8)
				defaultCryptoService.rsa.exportPrivateKeyJwk(loadedPairFromPkcs8.private) shouldBe privateKeyJwk
				defaultCryptoService.rsa.exportPublicKeyJwk(loadedPairFromPkcs8.public) shouldBe publicKeyJwk
				val loadedPairFromJwk = RsaKeypair(
					defaultCryptoService.rsa.loadPrivateKeyJwk(signatureAlgorithm, privateKeyJwk),
					defaultCryptoService.rsa.loadPublicKeyJwk(signatureAlgorithm, privateKeyJwk.extractPublic())
				)
				val data = "Hello, World!".toByteArray()
				defaultCryptoService.rsa.sign(data, loadedPairFromPkcs8.private).let {
					defaultCryptoService.rsa.verifySignature(it, data, loadedPairFromJwk.public) shouldBe true
				}
				defaultCryptoService.rsa.sign(data, loadedPairFromJwk.private).let {
					defaultCryptoService.rsa.verifySignature(it, data, loadedPairFromPkcs8.public) shouldBe true
				}
			}
		}
	}

	doSignatureTestsByAlgorithm(PssWithSha256)
})