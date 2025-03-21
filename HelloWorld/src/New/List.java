package New;

import java.util.ArrayList;

public class List {

    // Comment 클래스 (댓글 데이터)
    public static class Comment {
        public String content;
        public String password;
        public String timestamp;

        public Comment(String content, String password) {
            this.content = content;
            this.password = password;
            this.timestamp = getCurrentTimestamp();
        }

        // 현재 시간 반환
        public String getCurrentTimestamp() {
            return java.time.format.DateTimeFormatter.ofPattern("MM-dd/HH:mm:ss")
                    .format(java.time.LocalDateTime.now());
        }
    }

    // Post 클래스 (게시글 데이터)
    public static class Post {
        public String title;
        public String content;
        public String postPassword;
        public String timestamp;
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
            return java.time.format.DateTimeFormatter.ofPattern("MM-dd/HH:mm:ss")
                    .format(java.time.LocalDateTime.now());
        }
    }

    // User 클래스 (사용자 데이터)
    public static class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
