package com.icure.kryptom.crypto

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
	""".trimIndent(), // Note: the text has 4 trailing spaces (after `laborum.`). Removing them will make some tests fail.
	"Exactly 16 bytes"
)

fun String.mutations(): List<String> = listOf(
	drop(1),
	dropLast(1),
	"x$this",
	"$this;",
	"@${this.drop(1)}",
	"${this.dropLast(1)}#"
)

// Sample rsa private keys in pkcs8 (to use only for testing purposes)
val sampleRsaKeys = listOf(
	Pair(
		RsaService.KeySize.Rsa2048,
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
		RsaService.KeySize.Rsa4096,
		"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" +
			"fLX+CS54iCqSfu8ozP9+fpWj8+Ytkg=="
	)
)

fun sampleRsaKeysJwk(algorithm: RsaAlgorithm): List<Pair<RsaService.KeySize, PrivateRsaKeyJwk>> {
	val alg = algorithm.jwkIdentifier
	val usage = if (algorithm is RsaAlgorithm.RsaEncryptionAlgorithm) setOf("decrypt") else setOf("sign")
	return listOf(
		Pair(
			RsaService.KeySize.Rsa2048,
			PrivateRsaKeyJwk(
				alg=alg,
				d="YzSEMChTKK5oAZ3gO_CDkt2Kjyk909mRwbsKCBZCVh_O2raLVFuMn6AknfQntWJ-Lu0OC1BGSUg2AhPa4tRvSpym1oHzVu1BQuwpN6d0h0wtUmPNrGOLQnE8Wb7nol9vkaenJ1xW1aW-8MzrzgKsq9LjTFvpJM9971w1Kb9_wfTKNkd3jTC2oc-Ub_MVK4hCvU0_7DxMTDalTzrGKoRZQgdlFZ3FufK9Voyiz5J1K1nLVLme0EibGd2taYwggPKr2bGaIJBCENxIQbIPESwu6ZL5dTsmqtNRALGnVH_utvegBpsu7SMlCXE13CyI4EFD1c9wFrBNjSPx2ZjYrtFXfw",
				dp="EwjosWGq330KowcrHVG_jrHvDurBkGquJb2HBPSAUWcbj8fpdyN0lMJVjbOYU2tV5QIJawhrTGxff2IepdXnjnQXdLklBkadIEy-z9RoFZZmQlCq11Jzb8EC6FiHv9j84uxuNWe3aAyne0fDxvo-bf_ss-RZvV_3S8kjmB-sMlc",
				dq="zPDFeFK85nn-6K2G3cxRBIQzrd9nKV8XvoX2L3Zy8XZ8KM8ZN-U6cYBoi0JrT6haUD195FjtqAPKDbDFPTwWvqBbOZGDxqPw47vsatqcJWuU8qc6EDvTcFg88i5sqwIpA7kf_FEdYor5lP5n-KbGtm2HzCzDTWCV1ZxfzAP6CsU",
				e="AQAB",
				ext=true,
				key_ops=usage,
				n="0cJ8_jU1cyru5j4VaizE-nJUBvxWQJL-wE6X2xmaY7LiEY__GVN2vaF5iB-H9MCm6jfZURAsJn4FsWl3Y6FIpQ16jFK5OKJx2vxHxX82_gT8Ro9XDNMFcmYmG6uvL3ZiOEwGYnAfAVJ4L1--BCRQN9Q3-Z4IY5yp6qamx2ircPpIlkQhORrs-gNwXXA3P6g5gXfb0qi68n5Y1zBdW2Rl5c3Mo3oKsvY2mBYtL7kDqFzj1i5x5jFNvUXYsPvFBB6hxOg0S4Bl67pkgxROvC9L2oG54fhGvnREPTza1iUoVZNMTuq48IWxGXcan_imF-ZTInP3Ee8Bh3xr4tl6UDqN-Q",
				p="6gFtdC4cxaZ-rsmAxIscZtYpb1oP_9HUtIsa9oRPnT3A2NZs9kvDgPr5CeZDFgZ_dtlEezbO0aTaMh2VGmPawL1LYlPtuWRJhBmBJ_bGnVcOAihMEJTONkkGEVtK4gWzpHBsbG2G4TiwttPrYvjplfyTgwD9oj-1RHNpqKmgJpM",
				q="5XmqA-_2UBstH5J6OB8RBJAXl73R3kdnOHk6YRoI55vqnh6JxWbE1YZvIPKnURAhayqndKCUpOrC0RBPR6zhNh4nCloJZUmt7Zk3PG7qdGUiGXBd4J8nQF9fXmSlO118eoLu_fvuWIKjUYlryw3B3KkaERPvAQFnqRfO-ti9pMM",
				qi="y0JZWZvZBuXaKhq2poGYspCKfquq-fPcNIg9lD5Vz4bcrb4DKXmJ1V-_c33b1z1J11TT4svsestRf1vyzACQyfq1IXrBxPimsJWRprgi2LzlD8MyqzYd7Zj50Yjr5lQ5GKHrxLA_3Dcnwtg90HO4wYzcgkbx_JSTE8pJVt6LFmo"
			)
		),
		Pair(
			RsaService.KeySize.Rsa4096,
			PrivateRsaKeyJwk(
				alg=alg,
				d="B2tYMLG4DcfGiuveYTSo9ghgvoMCf0b5TRiWwrN0rtBboERzzziM5_-qU1A6qanFQEBgXceTMZUIp3R8BBeuhyX8pUi1cER5vz-PE1EUMq4d8ar4Nysd532VFjB-qlLmXvwFAmRv3Ei-maeE8napLLQT8dLRfBsU9vyseYGTP3uhr_xs4y3CMGF43p2h1q0GDp0hy9NHIlvDjLGLzroumwEH3fGfApz-O4QLmmuhKaLwxjXGNIF1nTeCAHz8c5EQaklI-_kUtQCkOtlK6487yJE1oPxlvMGZMLMtwRrg3dBwjpHql9MpxMUHjJr0_6ImrZovHzqEujwlZ8D6nu2Eiawn5xhxmn2lDSKA6d2AhrCU1h6OB883tCb13PPsOW0hUUgQr0ChFVLz2yc4kMf7muKlC7EQHcC7YSFXHvgew5dfPep5m2d3dIOkzjtevPrqlBMt7BEycZ45vFivfgBmAJCI1_0adGMFHgP-W9Ekn4uSlBycL9qjueYOyCko-YuQI8bxAVbfQp1URfxb99VYE4M43QxrKBTJBcWMeSTLJ3C9_DYpxCvNA1Fw1s5GxbnnYxx09mwpSQerRZXDo9V_7jK3f1KZD5m0-f0M_-SPlLM_vbyhIdzwtgeN95YtP3VUafDfgL0vjLavZEFBWyqmFOHA9lfKr13SxzQzZA8vQIE",
				dp="rzbAlzJc-6LUXhBFGqXjv7BXKRHMIveSk29a2sQzCOSCxRGzAsYBitrQFLRseUIWuweMENXtzisbbclp7qyfe0kVI19DDGaMz_AYFI4045Da8Y9mczy6hHEujkVrHrk2K40b5yg699R6QdTh28M6XZRhvg_zzY0XeTl0CkPyexYn40XhhdeK6RpdmpPzE-SuFCqiMaSKD-W5jHvbc3tN-7CWbPeA18W0JGYwZt5HMWi1PS46aGL1BQLkvUcIqByvF_qxLhl9642zbzXkCtbDiFYFgm9v7hIVM7QWsDzCM4uaS9wR74r4voTcKHGXhurNOaPffro0rG2P3s_0MX16uQ",
				dq="Zcx94d1LmTWvuk-bxL3iJqK9nHggbowaXqw15wA96Eyw2um9JICBjTbPCLv8_pIl9SsmP0Uo9IevL6JRGAIUyDe1LEtnNkm_k8USs38_qPeZMWXqqLylUjaxwQowl_dXbOf9RGPMh8XHPRFot793NaIxhAeO5hTxBJS3tWS7DIKvP6gusP21Jwi9O6FkQvuuTJr2yzob9cEvfbUsJcWe7HZ0889WJfti9K7A9yuW9EX4EgBmcsWGFa81qjMRoBZXrbOsCNtOiAWdlMG5l479ckuv4e0OIS4Q6kffkCwDxHF01U9q0NmsZ27bmAxI6TksLXoLO4fq7bVSYvaDRnZTkQ",
				e="AQAB",
				ext=true,
				key_ops=usage,
				n="s32NqKxwN-2CMS3EMEsMceeA4yeAc86JaMo3T05IOS0eNFw9NHs9Ydx_qtBGfJd5n5Mx0O78zUZsuJI8WGxa_L28dU7JYHnn-JA8wGqMyC4sxceqxjKQc_9MbcTshBHU5avlAxDwecXfJtnIz3wLR6ecAodyhs9vCzYY9wb4Qap-Z5Ub1wxR2ZnejizV-giTAehp7iWDOdMCZ91Fe7MDm8u6uq7qMVRHfW1xKQjwJjALct595nQOneu0BZMJN_4buLgERuGKczpsP6XTSaE_xL95o8VKGjVK9291TRO_bXWv9aZVyAh3cQCxDuJiVeobAO6WApytMeJLBf1jsEFX6M1AG7DIyar763xi5fXB0lGUMpLUpeOuWvoa1pgcO7ZgvxAwbgWPlu6unpNShA3FVdhYqBsXuFqRRtmQ4W8xAsjAXRH65lqHIRFoCtTDTWLykLHia29cg5igRiYNGRmF07c2UMT65K3hCl8Lj5bhAzcEE9rfpUrVEvBe1-o5EayZgbH5Sc1FWGKQxdl-c9Ai_cum6xs9AxYVkTxILAaO1Nb_48jL9B35WV4dyWrR2If9e5q2eUI08RCUcGQIiqOtiCuinLBlWd7EIwkkv2_FoKY-ohW3qQxyxhGul0iXwE1brh3KrLJcTsI-q-UHvFw9L-oSy9tti6GL_GqqeVDPyHk",
				p="7mtbaBrakIATvC4svQGR8zuwmN9lq2PICRFIEhEiqrFOMN8Hm9KsRd2wgz9m0o1P46vHo4ZQt-nlm-rtwMspXk0rZtZALMjRXyHoAqCVF62gXp_fhunZk6QaoyWtQ1dRpDj0pz2kWq0Al3Wx1jz_tkJ9l4VrEChsQLPayqERU_gK-nR2S6RjyCzPxNE35mZ6gCJOh4srIsbaObMWZoECfM5O2uzu3XAHn2bcPTQrejQCF_gWsxRDlsc3KxGLn2WDKzTw6gOlecQMgaLck9f05Zt0jPdiyCx0Ap86ChBv65PgK1JOWxkgep8ZxSXZmC8CVfQ3e-9T_XtXvcq5leJJ6Q",
				q="wLnLfyPIDTPa0R3qCe_ER7Xm3X_ZAK1KliCHRHGY3tJ2IM8-aPNCKbJlgNbq59Vgvxm1dZoFjxRyFpiZIKxfl7ss-GUD0i-2gLnQx0VeRLIubztvi_qShTAXP6KnqlVZ3Gy5xT7b06zmbR0dBRyHyMDcXTeYvtMn-3ypx7I0pfYaejWDqmVf5jCeOwxIW4XPn2X31kw1gr-W67C1HZ25CUL5XlP6zbOk3Kf44p94oxYEoRI3vS06YRvSyAQrax6QC1Mc4dhIf2fgqW8WBmiXKuhylBp5qvEVpfn-coTkODZwLRzVuTtAly6mMR47N5ruwHRgU62L-y4f57DybBXgEQ",
				qi="TX-elkqmmRgY1l0ZZN_ACHmkvLnLWDHMU1pmLLEtCBYTWWpBp1gD0VsxOgg0UkFoh7ECAgMrtVbA9luPnSj32erCo0C50wVxzqa2VRzg6rlQl9ZNAFSMtmxBDJTvQ2yWpw4GOgQifK4TYqxyd15nlI3BYxXao7Jf4oc_N7noMh9MTUECWHHtvnqi04rp0jg2mSXry942-uOTOHuTRlqaPeGGx1TxDVg94Yrm6IFYIfJDPpv-5bDKct1MJya4oGv7n4A48OVYMkIqAf1fHOHvvYR6tmXic2fN4ulBi7xJegjmki_HWA3pcjCBfLX-CS54iCqSfu8ozP9-fpWj8-Ytkg"
			)
		)
	)
}

// Public key spki corresponding to sampleRsaKeys
val sampleRsaKeysPublic = listOf(
	"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0cJ8/jU1cyru5j4VaizE+nJUBvxWQJL+wE6X2xmaY7LiEY//GVN2vaF5iB+H9MCm6jfZ" +
		"URAsJn4FsWl3Y6FIpQ16jFK5OKJx2vxHxX82/gT8Ro9XDNMFcmYmG6uvL3ZiOEwGYnAfAVJ4L1++BCRQN9Q3+Z4IY5yp6qamx2ircPpIlkQh" +
		"ORrs+gNwXXA3P6g5gXfb0qi68n5Y1zBdW2Rl5c3Mo3oKsvY2mBYtL7kDqFzj1i5x5jFNvUXYsPvFBB6hxOg0S4Bl67pkgxROvC9L2oG54fhG" +
		"vnREPTza1iUoVZNMTuq48IWxGXcan/imF+ZTInP3Ee8Bh3xr4tl6UDqN+QIDAQAB",
	"MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAs32NqKxwN+2CMS3EMEsMceeA4yeAc86JaMo3T05IOS0eNFw9NHs9Ydx/qtBGfJd5n5Mx" +
		"0O78zUZsuJI8WGxa/L28dU7JYHnn+JA8wGqMyC4sxceqxjKQc/9MbcTshBHU5avlAxDwecXfJtnIz3wLR6ecAodyhs9vCzYY9wb4Qap+Z5Ub" +
		"1wxR2ZnejizV+giTAehp7iWDOdMCZ91Fe7MDm8u6uq7qMVRHfW1xKQjwJjALct595nQOneu0BZMJN/4buLgERuGKczpsP6XTSaE/xL95o8VK" +
		"GjVK9291TRO/bXWv9aZVyAh3cQCxDuJiVeobAO6WApytMeJLBf1jsEFX6M1AG7DIyar763xi5fXB0lGUMpLUpeOuWvoa1pgcO7ZgvxAwbgWP" +
		"lu6unpNShA3FVdhYqBsXuFqRRtmQ4W8xAsjAXRH65lqHIRFoCtTDTWLykLHia29cg5igRiYNGRmF07c2UMT65K3hCl8Lj5bhAzcEE9rfpUrV" +
		"EvBe1+o5EayZgbH5Sc1FWGKQxdl+c9Ai/cum6xs9AxYVkTxILAaO1Nb/48jL9B35WV4dyWrR2If9e5q2eUI08RCUcGQIiqOtiCuinLBlWd7E" +
		"Iwkkv2/FoKY+ohW3qQxyxhGul0iXwE1brh3KrLJcTsI+q+UHvFw9L+oSy9tti6GL/GqqeVDPyHkCAwEAAQ=="
)