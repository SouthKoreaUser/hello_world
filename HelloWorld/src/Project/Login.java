package Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Comment {
    public String content;
    public String password; // 댓글 비밀번호
    public String timestamp; // 댓글 작성 시간

    public Comment(String content, String password) {
        this.content = content;
        this.password = password;
        this.timestamp = getCurrentTimestamp();
    }

    // 현재 시간 반환
    public String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd" +"/" + "HH:mm:ss");
        return sdf.format(new Date());
    }
}

class Post {
    public String title;
    public String content;
    public String postPassword; // 게시글 비밀번호
    public String timestamp; // 게시글 작성 시간
    public ArrayList<Comment> comments;

    public Post(String title, String content, String postPassword) {
        this.title = title;
        this.content = content;
        this.postPassword = postPassword;
        this.timestamp = getCurrentTimestamp();
        this.comments = new ArrayList<>();
    }

    // 현재 시간 반환
    public String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd" +"/" + "HH:mm:ss");
        return sdf.format(new Date());
    }

    public void addComment(String content, String password) {
        comments.add(new Comment(content, password));
    }

    public void editComment(int index, String newContent, String password) {
        if (index >= 0 && index < comments.size()) {
            if (comments.get(index).password.equals(password)) {
                comments.get(index).content = newContent;
                comments.get(index).timestamp = getCurrentTimestamp(); // 수정 후 타임스탬프 갱신
                System.out.println("댓글이 수정되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("댓글 번호가 유효하지 않습니다.");
        }
    }

    public void deleteComment(int index, String password) {
        if (index >= 0 && index < comments.size()) {
            if (comments.get(index).password.equals(password)) {
                comments.remove(index);
                System.out.println("댓글이 삭제되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("댓글 번호가 유효하지 않습니다.");
        }
    }

    // 게시글 수정 기능
    public void editPost(String newTitle, String newContent, String password) {
        if (this.postPassword.equals(password)) {
            this.title = newTitle;
            this.content = newContent;
            this.timestamp = getCurrentTimestamp(); // 수정 시 게시글 시간 갱신
            System.out.println("게시글이 수정되었습니다.");
        } else {
            System.out.println("게시글 비밀번호가 일치하지 않습니다.");
        }
    }

    // 게시글 삭제 기능
    public void deletePost(String password) {
        if (this.postPassword.equals(password)) {
            // 게시글 삭제 시 댓글도 모두 삭제됨
            comments.clear(); // 댓글 모두 삭제
            System.out.println("게시글과 해당 게시글의 댓글이 삭제되었습니다.");
        } else {
            System.out.println("게시글 비밀번호가 일치하지 않습니다.");
        }
    }

    // 댓글 목록 출력
    public void printComments() {
        System.out.println("--------------------------");
        System.out.println("댓글 목록:");
        if (comments.isEmpty()) {
            System.out.println("댓글이 없습니다.");
        } else {
            for (int i = 0; i < comments.size(); i++) {
                System.out.println((i + 1) + ". " + comments.get(i).content + " (" + comments.get(i).timestamp + ")");
            }
        }
        System.out.println("--------------------------"); // 구분선 추가
    }

    // 게시글 시간 출력
    public void printPost() {
        System.out.println("제목: " + title + "\t(" + timestamp + ")");
        System.out.println("내용: " + content);
    }
}

class User {
    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class Login {
    public static ArrayList<Post> posts = new ArrayList<>();
    public static User loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("user", "user"); // 기본 사용자

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
                    continue; // 엔터키 입력시 직전 단계로 돌아가기
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

    public static void writePost(Scanner scanner) {
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("게시글 비밀번호 (6자리): ");
        String postPassword = scanner.nextLine();
        if (postPassword.length() == 6) {
            posts.add(new Post(title, content, postPassword));
            System.out.println("글이 작성되었습니다.");
        } else {
            System.out.println("게시글 비밀번호는 6자리여야 합니다.");
        }
    }

    public static void viewPostList(Scanner scanner) {
        System.out.println("글 목록:");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println((i + 1) + ". " + posts.get(i).title + "\t(" + posts.get(i).timestamp + ")");
        }
        System.out.print("상세 글을 보려면 글의 번호를 입력하세요 (Enter키로 돌아가기): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return; // 엔터키 입력 시 돌아가기
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

    public static void viewPostDetail(Scanner scanner, Post post) {
        System.out.println("--------------------------");
        post.printPost();

        // 댓글 목록 출력
        post.printComments();

        // 댓글 추가
        System.out.println("--------------------------");
        System.out.println("0. 댓글 추가");
        System.out.print("댓글을 추가하려면 0을 입력하세요 (Enter키로 돌아가기): ");
        String action = scanner.nextLine();
        if (action.isEmpty()) {
            return; // 엔터키 입력 시 돌아가기
        }

        if (action.equals("0")) {
            System.out.print("댓글을 추가하려면 내용을 입력하세요: ");
            String commentContent = scanner.nextLine();
            System.out.print("댓글 비밀번호 (4자리): ");
            String commentPassword = scanner.nextLine();
            if (commentPassword.length() == 4) {
                post.addComment(commentContent, commentPassword);
                System.out.println("댓글이 추가되었습니다.");
            } else {
                System.out.println("댓글 비밀번호는 4자리여야 합니다.");
            }
        }

        post.printComments();  // 댓글 목록 다시 출력

        // 댓글 수정/삭제 선택
        System.out.println("--------------------------");
        System.out.println("1. 댓글 수정");
        System.out.println("2. 댓글 삭제");
        System.out.println("0. 신규 댓글 추가");
        System.out.print(" 신규 댓글 추가는 0 댓글 수정은 1, 댓글 삭제는 2, (Enter키로 돌아가기): ");
        action = scanner.nextLine();
        if (action.isEmpty()) {
            return; // 엔터키 입력 시 돌아가기
        }

        if (action.equals("1")) {
            editComment(scanner, post);
        } else if (action.equals("2")) {
            deleteComment(scanner, post);
        } else if (action.equals("0")) {
            viewPostDetail(scanner, post);  // 0번을 선택하면 댓글 추가 후 다시 상세보기
        }
    }

    public static void editComment(Scanner scanner, Post post) {
        System.out.print("수정할 댓글의 번호를 입력하세요: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < post.comments.size()) {
            System.out.print("새 댓글 내용을 입력하세요: ");
            String newContent = scanner.nextLine();
            System.out.print("댓글 비밀번호를 입력하세요: ");
            String password = scanner.nextLine();
            post.editComment(index, newContent, password);
            post.printComments(); // 수정 후 댓글 목록 다시 출력
        } else {
            System.out.println("유효하지 않은 댓글 번호입니다.");
        }
    }

    public static void deleteComment(Scanner scanner, Post post) {
        System.out.print("삭제할 댓글의 번호를 입력하세요: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < post.comments.size()) {
            System.out.print("댓글 비밀번호를 입력하세요: ");
            String password = scanner.nextLine();
            post.deleteComment(index, password);
            post.printComments(); // 삭제 후 댓글 목록 다시 출력
        } else {
            System.out.println("유효하지 않은 댓글 번호입니다.");
        }
    }
}
