package cn.itcast.mp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("tb_user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableId("user_name")
    private String userName;

    @TableId("password")
    private String password;

    @TableId("name")
    private String name;

    @TableId("email")
    private String email;

    @TableId("birthday")
    private Date birthday;

    @TableId("age")
    private Integer age;
}
