package br.com.wferdinando.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_TASKS")
public class TaskModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String description;

    @Column(length = 50)
    private String title;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private UUID idUser;

    public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O Campo title deve conter no máximo 50 caracteres.");
        }
        this.title = title;
    }
}