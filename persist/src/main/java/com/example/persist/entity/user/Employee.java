package com.example.persist.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qmt
 * @since 2019-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    private Long deptId;

    private LocalDateTime inputtime;

    private Boolean state;

    private Boolean admin;

    private Boolean gender;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String REALNAME = "realname";

    public static final String PASSWORD = "password";

    public static final String TEL = "tel";

    public static final String EMAIL = "email";

    public static final String DEPT_ID = "dept_id";

    public static final String INPUTTIME = "inputtime";

    public static final String STATE = "state";

    public static final String ADMIN = "admin";

    public static final String GENDER = "gender";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
