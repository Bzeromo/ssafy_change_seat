import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SSAFYChangeMembersSeat {
	static String [] member = {"박영규", "김준섭", "구본민", "김다윤", "김동학", "김보라", "김상민",
			"김은지", "이민형", "박소현", "안상준", "양성주", "양희태",
			"이준혁", "이창헌", "이현정"};
	static int memberCnt = member.length;
	static boolean satMember[] = new boolean [memberCnt];
	
	static String [] mentor = {"이수민", "이예원", "임지은", "전성수", "조민준", "조한빈", "천우진", "최유진", "최홍준"};
	static int mentorCnt = mentor.length;
	static boolean satMentor[] = new boolean [mentorCnt];
	
	static int seatCnt = 1;
	static int num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int option = 0;
		
		while(option != 3) {
			System.out.println("----------------------------------*SSAFY 자리 바꾸기 Ver1.0*-----------------------------------------");
			System.out.println("------------------------------------[Made by Bzeromo]--------------------------------------------");
			System.out.println("----------------------------(실행 전 member와 mentor 입력을 완료해주세요.)----------------------------------");
			System.out.println("-- 1. 기본형 자리 바꾸기                                                                                                                                                                               --");
			System.out.println("-- 2. 멘토배치형 자리 바꾸기                                                                                                                                                                         --");
			System.out.println("-- 3. 나가기                                                                                                                                                                                                --");
			System.out.println("----------------------------------원하는 옵션의 번호를 입력해주세요.-----------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.print(">> ");
			
			sb.delete(0, sb.length());
			option = Integer.parseInt(br.readLine());
			
			if(option == 1) {
				sb.append("\n\n\n\n\n-----------------------------------------------------------------------------\n");
				sb.append("-----------------------------------화이트보드------------------------------------\n");
				satMember = new boolean [memberCnt];
				num = 0;
				for(int i = 0; i < memberCnt/6+1; i++) {
					if(num == memberCnt) break;
					int n = 0;
					sb.append("--|");
					while(n != 6) {
						if(num == memberCnt) break;
						
						int memberNum = (int)(Math.random() * memberCnt);
						
						if(satMember[memberNum]) continue;
						
						if(n == 3) sb.append("          |");
						
						sb.append("   ").append(member[memberNum]).append("     |");
						satMember[memberNum] = true;
						n++;
						num++;
					}
					sb.append("--\n");
				}
				sb.append("-----------------------------------------------------------------------------\n");
				sb.append("------------------------------------------------------------------------------");
				System.out.println(sb.toString());
			} else if(option == 2) {
				sb.append("\n\n\n\n\n------------------------------------------------------------------------------\n");
				sb.append("-----------------------------------화이트보드------------------------------------\n");
				satMember = new boolean [memberCnt];
				satMentor = new boolean[mentorCnt];
				seatCnt = 1;
				num = 0;
				for(int i = 0; i < (memberCnt+mentorCnt)/6+1; i++) {
					if(num == memberCnt+mentorCnt) break;
					int n = 0;
					sb.append("--|");
					loop: while(n != 6) {
						if(num == memberCnt + mentorCnt) break;
						
						if(seatCnt != 2) {
							int memberNum = (int)(Math.random() * memberCnt);
							
							if(satMember[memberNum] && num > memberCnt) {
								for(int j = 0; j < satMember.length; j++) {
									if(!satMember[j]) continue loop;
								}
								
								for(int j = 0; j < satMentor.length; j++) {
									if(!satMentor[j]) {
										sb.append("   ").append(mentor[j]).append("     |");
										num++;
										break loop;
									}
									
								}
							}
							
							if(n == 3) sb.append("          |");
							
							sb.append("   ").append(member[memberNum]).append("     |");
							satMember[memberNum] = true;
							n++;
							num++;
							seatCnt++;
						} else {
							int mentorNum = (int)(Math.random() * mentorCnt);
							
							if(satMentor[mentorNum]) continue;
							
							sb.append("   ").append(mentor[mentorNum]).append("     |");
							satMentor[mentorNum] = true;
							n++;
							num++;
							seatCnt = 0;
						}
						
					}
					sb.append("--\n");
				}
				sb.append("-----------------------------------------------------------------------------\n");
				sb.append("------------------------------------------------------------------------------");
				System.out.println(sb.toString());
			} else if(option == 3)  {
				break;
			}
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요. \n\n\n\n");
				continue;
			}
			System.out.println("\n\n\n\n\n-------------------------------------------------------------------------------------------------");
			System.out.println("-- 다시 하시겠습니까?                                                                                --");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("-- 1. 네                                                                                                                                                                                                      --");
			System.out.println("-- 2. 매우 강렬하게 네                                                                                                                                                                                  --");
			System.out.println("-- 3. 나가기                                                                                                                                                                                                --");
			System.out.println("----------------------------------원하는 옵션의 번호를 입력해주세요.-----------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.print(">> ");
			option = Integer.parseInt(br.readLine());
		}
		System.out.println("\n\n\n(   프로그램이 종료되었습니다. 이용해주셔서 감사합니다.   )\n\n\n");
		System.out.println("GitHub Repogitory: https://github.com/Bzeromo/ssafy_change_seat");
		System.out.println("Bzeromo Velog: https://velog.io/@bzeromo");
		System.out.println("개발자 커피 사주기: 945802-00-283272 국민");
		br.close();
	}

}
