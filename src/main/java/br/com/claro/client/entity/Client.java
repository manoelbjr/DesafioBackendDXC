package br.com.claro.client.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String email;

    @Column()
    private LocalDate birthDate;

    @Column()
    private String cpf;

}
