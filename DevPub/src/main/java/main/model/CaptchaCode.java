package main.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "captcha_codes")
public class CaptchaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;


    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "secret_code", nullable = false)
    private String secretCode;
}
