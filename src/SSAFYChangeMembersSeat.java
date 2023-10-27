import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SSAFYChangeMembersSeat {
	static String [] member = {"이예원", "천우진", "구본민", "김다윤", "김동학", "김보라", "조민준",
			"김은지", "전성수", "박소현", "이수민", "양성주", "양희태", "이준혁", "이창헌", "최홍준"};
	static int memberCnt = member.length;
	static boolean satMember[] = new boolean [memberCnt];
	
	static String [] mentor = {"박영규", "임지은", "이민형", "김상민", "조한빈", "김준섭", "최유진", "이현정", "안상준"};
	static int mentorCnt = mentor.length;
	static boolean satMentor[] = new boolean [mentorCnt];
	
	static int seatCnt = 1;
	static int num;
	
	//중간에 비워야 할 자리가 있다면 해당 자리의 번호로 값을 수정해주세요.
	//3자리까지 비울 수 있습니다.
	//멘토의 자리는 비우지 마세요!
	static int emptySeat1 = 10;
	static int emptySeat2 = 15;
	static int emptySeat3 = 16;
	
	static {
		if(emptySeat1 < emptySeat2 && emptySeat2 < emptySeat3) {
			emptySeat2--;
			emptySeat3 -= 2;
		} else if(emptySeat1 > emptySeat2 && emptySeat2 > emptySeat3) {
			emptySeat2--;
			emptySeat1 -= 2;
		} else if(emptySeat2 > emptySeat1 && emptySeat1 > emptySeat3) {
			emptySeat1--;
			emptySeat2 -= 2;
		} else if(emptySeat3 > emptySeat1 && emptySeat1 > emptySeat2) {
			emptySeat1--;
			emptySeat3 -= 2;
		}else if(emptySeat2 > emptySeat3 && emptySeat3 > emptySeat1) {
			emptySeat3--;
			emptySeat2 -= 2;
		} else if(emptySeat1 > emptySeat3 && emptySeat3 > emptySeat2) {
			emptySeat3--;
			emptySeat1 -= 2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int option = 0;
		
		while(option != 3) {
			System.out.println("----------------------------------*SSAFY 자리 바꾸기 Ver1.2*-----------------------------------------");
			System.out.println("------------------------------------[Made by Bzeromo]--------------------------------------------");
			System.out.println("----------------------------(실행 전 member와 mentor 입력을 완료해주세요.)---------------------------------");
			System.out.println("-- 1. 기본형 자리 바꾸기                                                                                                                                      --");
			System.out.println("-- 2. 멘토배치형 자리 바꾸기                                                                                                                                 --");
			System.out.println("-- 3. 나가기                                                                                                                                                     --");
			System.out.println("----------------------------------원하는 옵션의 번호를 입력해주세요.---------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.print(">> ");
			
			boolean emptySeatUse1 = false;
			boolean emptySeatUse2 = false;
			boolean emptySeatUse3 = false;
			
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
						
						if(num == emptySeat1-1 && !emptySeatUse1) {
							
							sb.append("          |");
							
							System.out.println(num);
							n++;
							emptySeatUse1 = true;
							continue;
						}
						
						if(num == emptySeat2-1 && !emptySeatUse2) {
							
							sb.append("          |");
							
							System.out.println(num);
							n++;
							emptySeatUse2 = true;
							continue;
						}
						
						if(num == emptySeat3-1 && !emptySeatUse3) {
							
							sb.append("          |");
							
							n++;
							emptySeatUse3 = true;
							continue;
						}
						
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
							if(num == emptySeat1-1 && !emptySeatUse1) {
								if(n == 3) sb.append("          |");
								
								sb.append("          |");
								
								n++;
								seatCnt++;
								emptySeatUse1 = true;
								continue;
							}
							
							if(num == emptySeat2-1 && !emptySeatUse2) {
								if(n == 3) sb.append("          |");

								sb.append("          |");
								
								n++;
								seatCnt++;
								emptySeatUse2 = true;
								continue;
							}
							
							if(num == emptySeat3-1 && !emptySeatUse3) {
								if(n == 3) sb.append("          |");

								sb.append("          |");
								
								n++;
								seatCnt++;
								emptySeatUse3 = true;
								continue;
							}
							
							int memberNum = (int)(Math.random() * memberCnt);
							
							if(satMember[memberNum] && num-mentorCnt >= memberCnt) {
								for(int j = 0; j < satMentor.length; j++) {
									if(!satMentor[j]) {
										sb.append("   ").append(mentor[j]).append("     |");
										num++;
										break loop;
									}
									
								}
							}
							
							if(satMember[memberNum]) continue;
							
							if(n == 3) sb.append("          |");
							
							sb.append("   ").append(member[memberNum]).append("     |");
							satMember[memberNum] = true;
							n++;
							num++;
							seatCnt++;
						} else {
							if(num == emptySeat1-1 && !emptySeatUse1) {
								if(n == 3) sb.append("          |");
								
								sb.append("          |");
								
								n++;
								seatCnt = 0;
								emptySeatUse1 = true;
								continue;
							}
							
							if(num == emptySeat2-1 && !emptySeatUse2) {
								if(n == 3) sb.append("          |");
								
								sb.append("          |");
								
								n++;
								seatCnt = 0;
								emptySeatUse2 = true;
								continue;
							}
							
							if(num == emptySeat3-1 && !emptySeatUse3) {
								if(n == 3) sb.append("          |");

								sb.append("          |");
								
								n++;
								seatCnt = 0;
								emptySeatUse3 = true;
								continue;
							}
							
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
			System.out.println("\n\n\n");
		}
		System.out.println("(   프로그램이 종료되었습니다. 이용해주셔서 감사합니다.   )\n\n\n");
		System.out.println("GitHub Repogitory: https://github.com/Bzeromo/ssafy_change_seat");
		System.out.println("Bzeromo Velog: https://velog.io/@bzeromo");
		System.out.println("개발자 커피 사주기: 945802-00-283272 국민");
		br.close();
	}

}
