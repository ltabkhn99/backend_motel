package vn.oceantech.l3pre.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "motel_room")
public class MotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;  // mô tả

    @Column(name = "price")
    private Double price;  // giá

    @Column(name = "acreage")
    private Double acreage; // diện tích

    @Column(name = "max_number_people")
    private Integer maxNumberPeople; // số lượng người tối đa

    @Column(name = "post_time")
    private LocalDateTime postTime; // thời gian đăng tải

    @OneToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Province province;  // tinh

    @OneToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;  // quận

    @OneToOne
    @JoinColumn(name = "sub_district_id", referencedColumnName = "id")
    private SubDistrict subDistrict;  // phường

    @Column(name = "address")
    private String address; // số nhà, đường

    @ManyToOne
    @JoinColumn(name = "type_room_id", referencedColumnName = "id")
    private TypeRoom typeRoom;  // loại phòng trọ

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "neighbor_university")
    private String neighborUniversity;  // trường đại học lân cận

    @Column(name = "link_gg_map")
    private String linkGgMap;  // link gg map

    @Column(name = "image")
    private String image;  // ảnh phòng

    @Column(name = "cover_image")
    private String coverImage;  // ảnh bìa
}
