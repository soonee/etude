package com.soonee.test.programmers.level1;

public class NewIdRecommendation {

	public static String solution(String new_id) {
		System.out.println("---------------------------------------");
		System.out.println(new_id);

		String answer = new_id.toLowerCase(); // 1단계
		answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
		answer = answer.replaceAll("[.]{2,}", "."); // 3단계
		answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계

		if (answer.equals("")) {    // 5단계
			answer += "a";
		}

		if (answer.length() >= 16) {     // 6단계
			answer = answer.substring(0, 15);
			answer = answer.replaceAll("[.]$","");
		}

		if (answer.length() <= 2) {  // 7단계
			while (answer.length() < 3) {
				answer += answer.charAt(answer.length()-1);
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		NewIdRecommendation.solution("...!@BaT#*..y.abcdefghijklm");
		NewIdRecommendation.solution("z-+.^.");
		NewIdRecommendation.solution("=.=");
		NewIdRecommendation.solution("123_.def");
		NewIdRecommendation.solution("abcdefghijklmn.p");
		NewIdRecommendation.solution("==");
	}
}
