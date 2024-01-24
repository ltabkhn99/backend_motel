package vn.oceantech.l3pre.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "receive_notification")
public class ReceiveNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Province province;  // tinh

    @OneToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;  // quận

    @OneToOne
    @JoinColumn(name = "sub_district_id", referencedColumnName = "id")
    private SubDistrict subDistrict;  // phường
}
