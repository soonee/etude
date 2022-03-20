package com.soonee.test.programmers.level1;

import java.util.*;

public class GetReport {
	// 21:00
	public int[] solution(String[] id_list, String[] report, int k) {
		// 유저 목록, 신고 당한 횟수
		Map<String, Integer> user = new HashMap<>();
		for (String u : id_list) {
			user.putIfAbsent(u, 0);
		}
		// 신고 내역 중복 제거
		report = Arrays.stream(report).distinct().toArray(String[]::new);
		System.out.println("id_list: " + Arrays.asList(id_list));
		System.out.println("report: " + Arrays.asList(report));

		// 신고 횟수 추출
		Map<String, List<String>> reportMap = new HashMap<>();
		for (String r : report) {
			String[] reportByUser = r.split(" ");
			// 신고자
			String reporter = reportByUser[0];
			// 신고당한사람
			String reportee = reportByUser[1];
			// 신고 횟수
			int count = user.getOrDefault(reportee, 0) + 1;
			user.put(reportee, count);
			// 신고자 저장
			List<String> reportees = reportMap.getOrDefault(reporter, new ArrayList<>());
			reportees.add(reportee);
			reportMap.put(reporter, reportees);
		}
		System.out.println("## user report count: " + Arrays.asList(user));
		System.out.println("## report map: " + Arrays.asList(reportMap));

		int[] answer = new int[id_list.length];
		// 신고 대상자 조회 (k번 이상)
		for (String reportee : id_list) {
			if (user.get(reportee) >= k) {
				int index = 0;
				// 신고자 메일 횟수 체크
				for (String reporter : id_list) {
					if (reportMap.getOrDefault(reporter, new ArrayList<>()).contains(reportee)) {
						System.out.printf("신고자: %s, 신고대상자: %s\n", reporter, reportee);
						answer[index]++;
					}
					index++;
				}
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static void main(String[] args) {
		GetReport r = new GetReport();
		r.solution(
				new String[]{"muzi", "frodo", "apeach", "neo"},
				new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "muzi frodo", "apeach muzi"},
				2
		);
	}
}
