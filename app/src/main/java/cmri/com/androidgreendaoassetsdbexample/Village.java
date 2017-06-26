/*
 * Copyright (c) 2017. CMRI PRIVATE LIMITED. All rights reserved
 * Created by WangBo on 17-6-23 上午11:48
 *
 * Last modified 17-6-23 上午11:48
 */

package cmri.com.androidgreendaoassetsdbexample;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Entity mapped to table "NOTE".
 */
@Entity(
        nameInDb = "village",
        createInDb = false
)
public class Village {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "code")
    private int code;
    @Property(nameInDb = "town_id")
    private int town_id;
    @Generated(hash = 1910353232)
    public Village(Long id, String name, int code, int town_id) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.town_id = town_id;
    }
    @Generated(hash = 861187015)
    public Village() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return this.code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getTown_id() {
        return this.town_id;
    }
    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }

}
