package New;

import New.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static ArrayList<List.Post> posts = new ArrayList<>();
    public static List.User loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List.User user = new List.User("user", "user");

        System.out.println("로그인 해주세요.");
        System.out.print("사용자 이름: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        if (username.equals(user.username) && password.equals(user.password)) {
            loggedInUser = user;
            System.out.println("로그인 성공!");
            boolean running = true;

            while (running) {
                System.out.println("\n--------------------------");
                System.out.println("1. 글 작성");
                System.out.println("2. 글 목록 보기");
                System.out.println("3. 로그아웃");
                System.out.print("원하는 작업을 선택하세요: ");
                String choice = scanner.nextLine();

                if (choice.isEmpty()) {
                    continue;
                }

                int action = -1;
                try {
                    action = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }

                switch (action) {
                    case 1:
                        writePost(scanner);
                        break;
                    case 2:
                        viewPostList(scanner);
                        break;
                    case 3:
                        loggedInUser = null;
                        running = false;
                        System.out.println("로그아웃 되었습니다.");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다.");
                }
            }
        } else {
            System.out.println("로그인 실패. 사용자 이름 또는 비밀번호가 잘못되었습니다.");
        }

        scanner.close();
    }

    // 게시글 작성
    public static void writePost(Scanner scanner) {
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("게시글 비밀번호 (6자리): ");
        String postPassword = scanner.nextLine();
        if (postPassword.length() == 6) {
            posts.add(new List.Post(title, content, postPassword));
            System.out.println("글이 작성되었습니다.");
        } else {
            System.out.println("게시글 비밀번호는 6자리여야 합니다.");
        }
    }

    // 글 목록 보기
    public static void viewPostList(Scanner scanner) {
        System.out.println("글 목록:");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println((i + 1) + ". " + posts.get(i).title + "\t(" + posts.get(i).timestamp + ")");
        }
        System.out.print("상세 글을 보려면 글의 번호를 입력하세요 (Enter키로 돌아가기): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return;
        }

        try {
            int postIndex = Integer.parseInt(input) - 1;
            if (postIndex >= 0 && postIndex < posts.size()) {
                viewPostDetail(scanner, posts.get(postIndex));
            } else {
                System.out.println("유효하지 않은 글 번호입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // 글 상세 보기
    public static void viewPostDetail(Scanner scanner, List.Post post) {
        System.out.println("--------------------------");
        System.out.println("제목: " + post.title);
        System.out.println("내용: " + post.content);
        System.out.println("작성일: " + post.timestamp);

        printComments(post);

        // 댓글 수정/삭제/추가 선택
        System.out.println("--------------------------");
        System.out.println("1. 댓글 수정");
        System.out.println("2. 댓글 삭제");
        System.out.println("0. 신규 댓글 추가");
        System.out.print("선택 (0: 신규 댓글 추가, 1: 댓글 수정, 2: 댓글 삭제, Enter: 돌아가기): ");
        String action = scanner.nextLine();
        if (action.isEmpty()) {
            return;
        }

        if (action.equals("1")) {
            editComment(scanner, post);
        } else if (action.equals("2")) {
            deleteComment(scanner, post);
        } else if (action.equals("0")) {
            addComment(scanner, post);  // 신규 댓글 추가
        }
    }

    // 댓글 목록 출력
    public static void printComments(List.Post post) {
        System.out.println("댓글 목록:");
        if (post.comments.isEmpty()) {
            System.out.println("댓글이 없습니다.");
        } else {
            for (int i = 0; i < post.comments.size(); i++) {
                System.out.println((i + 1) + ". " + post.comments.get(i).content + " (" + post.comments.get(i).timestamp + ")");
            }
        }
        System.out.println("--------------------------");
    }

    // 댓글 추가
    public static void addComment(Scanner scanner, List.Post post) {
        System.out.print("댓글 내용을 입력하세요: ");
        String commentContent = scanner.nextLine();
        System.out.print("댓글 비밀번호 (4자리): ");
        String commentPassword = scanner.nextLine();
        if (commentPassword.length() == 4) {
            post.comments.add(new List.Comment(commentContent, commentPassword));
            System.out.println("댓글이 추가되었습니다.");
        } else {
            System.out.println("댓글 비밀번호는 4자리여야 합니다.");
        }
    }

    // 댓글 수정
    public static void editComment(Scanner scanner, List.Post post) {
        System.out.print("수정할 댓글의 번호를 입력하세요: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < post.comments.size()) {
            System.out.print("새 댓글 내용을 입력하세요: ");
            String newContent = scanner.nextLine();
            System.out.print("댓글 비밀번호를 입력하세요: ");
            String password = scanner.nextLine();
            if (password.equals(post.comments.get(index).password)) {
                post.comments.get(index).content = newContent;
                System.out.println("댓글이 수정되었습니다.");
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            System.out.println("유효하지 않은 댓글 번호입니다.");
        }
    }

    // 댓글 삭제
    public static void deleteComment(Scanner scanner, List.Post post) {
        System.out.print("삭제할 댓글의 번호를 입력하세요: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < post.comments.size()) {
            System.out.print("댓글 비밀번호를 입력하세요: ");
            String password = scanner.nextLine();
            if (password.equals(post.comments.get(index).password)) {
                post.comments.remove(index);
                System.out.println("댓글이 삭제되었습니다.");
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            System.out.println("유효하지 않은 댓글 번호입니다.");
        }
    }
}
