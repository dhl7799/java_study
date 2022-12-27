package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add( new User( "둘리", "1234") );
		joinUsers.add( new User( "마이콜", "5678") );
		joinUsers.add( new User( "또치", "4321") );
		joinUsers.add( new User( "도우너", "8765") );
		
		
		System.out.print("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();

		try {
			login(joinUsers, new User( id, password) );
			System.out.println("로그인 성공");
		} catch (UserNotFoundException ex) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		} catch( PasswordDismatchException ex ){
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		} finally {
			scanner.close();
		}
	}
	
	public static void login (List<User> users, User user ) throws Exception{
		int foundindex = 0;
		//1 2 3 4, 0 1 2 3
		for(int i=0; i<users.size();i++) {
			if(users.get(i).equals(user))
				break;
			foundindex++;
			
		}
		if(foundindex == users.size())
			throw new UserNotFoundException();
		
		if (!user.getPassword().equals(users.get(foundindex).getPassword())) {
			throw new PasswordDismatchException();
        }
		
	}
}