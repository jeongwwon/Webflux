package com.example.webflux1.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@Table("posts")
@AllArgsConstructor
public class Post {
    @Id
    private Long id;

    @Column("user_id")
    private Long userId;

    private String title;
    private String content;

    @Transient
    private User user;
    @Column("created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column("updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

//    +------------+--------------+------+-----+-------------------+-------------------+
//            | Field      | Type         | Null | Key | Default           | Extra             |
//            +------------+--------------+------+-----+-------------------+-------------------+
//            | id         | bigint       | NO   | PRI | NULL              | auto_increment    |
//            | title      | varchar(30)  | YES  |     | NULL              |                   |
//            | content    | varchar(200) | YES  |     | NULL              |                   |
//            | user_id    | bigint       | YES  | MUL | NULL              |                   |
//            | created_at | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//            | updated_at | datetime     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//            +------------+--------------+------+-----+-------------------+-------------------+
}
