package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // many-to-one
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username",
                nullable = false)
    private User user;
}
