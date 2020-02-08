package cn.yoursky.jpademo.entity.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
public class Roles implements Serializable {
    @Column(name = "r_id")
    @Id
    private long rid;

    @Column(name = "r_name")
    private String rName;
}
