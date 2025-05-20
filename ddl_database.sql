-- test.article definition

-- Drop table

-- DROP TABLE article;

CREATE TABLE article
(
    article_seq        VARCHAR(100) NOT NULL,
    content            LONGTEXT,
    title              LONGTEXT,
    is_show            VARCHAR(1),
    temp_yn            VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    description        LONGTEXT,
    status             VARCHAR(20),
    CONSTRAINT `PRIMARY` PRIMARY KEY (article_seq)
);


-- test.banner definition

-- Drop table

-- DROP TABLE banner;

CREATE TABLE banner
(
    banner_seq         VARCHAR(100) NOT NULL,
    banner_nm          VARCHAR(100),
    banner_type        VARCHAR(100),
    use_yn             VARCHAR(1),
    start_date         DATETIME,
    end_date           DATETIME,
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(1),
    url                VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (banner_seq)
);


-- test.category definition

-- Drop table

-- DROP TABLE category;

CREATE TABLE category
(
    category_seq       VARCHAR(100) NOT NULL,
    category_type      VARCHAR(100),
    category_nm        VARCHAR(100),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (category_seq)
);


-- test.category_ref definition

-- Drop table

-- DROP TABLE category_ref;

CREATE TABLE category_ref
(
    category_ref_seq   VARCHAR(100) NOT NULL,
    ref_seq            VARCHAR(100),
    type_cd            VARCHAR(100),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (category_ref_seq)
);


-- test.code_mng definition

-- Drop table

-- DROP TABLE code_mng;

CREATE TABLE code_mng
(
    cd_id    VARCHAR(255) NOT NULL,
    cd_key   VARCHAR(255),
    cd_name  VARCHAR(255),
    order_by VARCHAR(255),
    up_cd_id VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (cd_id)
);


-- test.comment_mng definition

-- Drop table

-- DROP TABLE comment_mng;

CREATE TABLE comment_mng
(
    comment_mng_seq    VARCHAR(100) NOT NULL,
    content            LONGTEXT,
    parent_id          VARCHAR(100),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    ref_seq            VARCHAR(100),
    type_cd            VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (comment_mng_seq)
);


-- test.cps_seq_mng definition

-- Drop table

-- DROP TABLE cps_seq_mng;

CREATE TABLE cps_seq_mng
(
    tbl_name VARCHAR(100) NOT NULL,
    prefix   VARCHAR(100),
    last_num DECIMAL(10, 0),
    CONSTRAINT `PRIMARY` PRIMARY KEY (tbl_name)
);


-- test.file_mng definition

-- Drop table

-- DROP TABLE file_mng;

CREATE TABLE file_mng
(
    created_date       DATETIME,
    file_size          BIGINT,
    last_modified_date DATETIME,
    created_by         VARCHAR(255),
    del_yn             VARCHAR(255),
    file_name          VARCHAR(255),
    file_path          VARCHAR(255),
    file_type          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    producer_code      VARCHAR(255),
    producer_id        VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.follower_mng definition

-- Drop table

-- DROP TABLE follower_mng;

CREATE TABLE follower_mng
(
    follower_mng_seq   VARCHAR(100) NOT NULL,
    follower_user      VARCHAR(100),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (follower_mng_seq)
);


-- test.food definition

-- Drop table

-- DROP TABLE food;

CREATE TABLE food
(
    food_seq           VARCHAR(100) NOT NULL,
    name               VARCHAR(100),
    food_cate_seq      VARCHAR(100),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_by         VARCHAR(100),
    created_date       DATETIME,
    last_modified_by   VARCHAR(100),
    last_modified_date DATETIME,
    reduce_yn          VARCHAR(1),
    description        LONGTEXT,
    food_store_seq     VARCHAR(100),
    price              DECIMAL(10, 0),
    price_reduce       DECIMAL(10, 0),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_seq)
);


-- test.food_cate definition

-- Drop table

-- DROP TABLE food_cate;

CREATE TABLE food_cate
(
    food_cate_seq      VARCHAR(100) NOT NULL,
    name               VARCHAR(100),
    del_yn             VARCHAR(1),
    created_by         VARCHAR(100),
    created_date       DATETIME,
    last_modified_by   VARCHAR(100),
    last_modified_date DATETIME,
    food_store_seq     VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_cate_seq)
);


-- test.food_order definition

-- Drop table

-- DROP TABLE food_order;

CREATE TABLE food_order
(
    food_order_seq     VARCHAR(100) NOT NULL,
    food_store_seq     VARCHAR(100),
    code               VARCHAR(100),
    status             VARCHAR(100),
    receiver_nm        VARCHAR(100),
    receiver_phone     VARCHAR(100),
    receiver_address   VARCHAR(2000),
    del_yn             VARCHAR(1),
    created_by         VARCHAR(100),
    created_date       DATETIME,
    last_modified_by   VARCHAR(100),
    last_modified_date DATETIME,
    description        LONGTEXT,
    price_total        DECIMAL(10, 0),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_order_seq)
);


-- test.food_order_appr definition

-- Drop table

-- DROP TABLE food_order_appr;

CREATE TABLE food_order_appr
(
    food_order_appr_seq VARCHAR(100) NOT NULL,
    status              VARCHAR(100),
    content             LONGTEXT,
    reject              LONGTEXT,
    created_by          VARCHAR(100),
    created_date        DATETIME,
    last_modified_by    VARCHAR(100),
    last_modified_date  DATETIME,
    del_yn              VARCHAR(1),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_order_appr_seq)
);


-- test.food_order_detail definition

-- Drop table

-- DROP TABLE food_order_detail;

CREATE TABLE food_order_detail
(
    food_order_detail_seq VARCHAR(100) NOT NULL,
    food_order_seq        VARCHAR(100),
    food_seq              VARCHAR(100),
    quantity              DECIMAL(10, 0),
    created_by            VARCHAR(100),
    created_date          DATETIME,
    last_modified_by      VARCHAR(100),
    last_modified_date    DATETIME,
    del_yn                VARCHAR(1),
    price                 DECIMAL(10, 0),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_order_detail_seq)
);


-- test.food_order_employ definition

-- Drop table

-- DROP TABLE food_order_employ;

CREATE TABLE food_order_employ
(
    food_order_employ_seq VARCHAR(100) NOT NULL,
    employ_seq            VARCHAR(100),
    food_order_seq        VARCHAR(100),
    created_by            VARCHAR(100),
    created_date          DATETIME,
    last_modified_by      VARCHAR(100),
    last_modified_date    DATETIME,
    del_yn                VARCHAR(1),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_order_employ_seq)
);


-- test.food_order_voucher definition

-- Drop table

-- DROP TABLE food_order_voucher;

CREATE TABLE food_order_voucher
(
    food_order_voucher_seq VARCHAR(100),
    food_order_seq         VARCHAR(100),
    voucher_seq            VARCHAR(100),
    del_yn                 VARCHAR(1),
    created_date           DATETIME,
    created_by             VARCHAR(100),
    last_modified_date     DATETIME,
    last_modified_by       VARCHAR(100)
);


-- test.food_store definition

-- Drop table

-- DROP TABLE food_store;

CREATE TABLE food_store
(
    food_store_seq     VARCHAR(100),
    nm                 VARCHAR(100),
    owner_seq           VARCHAR(100),
    address             VARCHAR(1000),
    phone_owner         VARCHAR(100),
    phone_sp            VARCHAR(100),
    is_show_phone_owner VARCHAR(100),
    is_badge             VARCHAR(25),
    avatar              VARCHAR(100),
    is_activity         VARCHAR(25),
    created_by         VARCHAR(255),
    created_date       DATETIME,
    del_yn             VARCHAR(255),
    last_modified_by   VARCHAR(255),
    last_modified_date DATETIME
);


-- test.food_store_user definition

-- Drop table

-- DROP TABLE food_store_user;

CREATE TABLE food_store_user
(
    food_store_user_seq VARCHAR(100) NOT NULL,
    food_store_seq      VARCHAR(100),
    user_id             VARCHAR(100),
    position_seq        VARCHAR(100),
    del_yn              VARCHAR(1),
    created_date        DATETIME,
    created_by          VARCHAR(100),
    last_modified_date  DATETIME,
    last_modified_by    VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (food_store_user_seq)
);


-- test.hashtag_mng definition

-- Drop table

-- DROP TABLE hashtag_mng;

CREATE TABLE hashtag_mng
(
    hashtag_mng_seq    VARCHAR(100) NOT NULL,
    hashtag_nm         VARCHAR(100),
    del_yn             VARCHAR(100),
    use_yn             VARCHAR(100),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (hashtag_mng_seq)
);


-- test.hashtag_ref definition

-- Drop table

-- DROP TABLE hashtag_ref;

CREATE TABLE hashtag_ref
(
    hashtag_ref_seq    VARCHAR(100) NOT NULL,
    ref_seq            VARCHAR(100),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    type_cd            VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (hashtag_ref_seq)
);


-- test.language_mng definition

-- Drop table

-- DROP TABLE language_mng;

CREATE TABLE language_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    created_by         VARCHAR(255),
    del_yn             VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    name               VARCHAR(255),
    note               VARCHAR(255),
    `type`             VARCHAR(255),
    value              VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.like_mng definition

-- Drop table

-- DROP TABLE like_mng;

CREATE TABLE like_mng
(
    like_mng_seq       VARCHAR(100) NOT NULL,
    ref_seq            VARCHAR(100),
    like_type          VARCHAR(100),
    use_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(1),
    CONSTRAINT `PRIMARY` PRIMARY KEY (like_mng_seq)
);


-- test.menu definition

-- Drop table

-- DROP TABLE menu;

CREATE TABLE menu
(
    menu_id       VARCHAR(100) NOT NULL,
    site_type     VARCHAR(100),
    name          VARCHAR(100),
    route         VARCHAR(100),
    parent_id     VARCHAR(100),
    display_order VARCHAR(100),
    del_yn        VARCHAR(100),
    nm            VARCHAR(100),
    useyn         VARCHAR(1),
    use_yn        VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (menu_id)
);


-- test.menu_cook definition

-- Drop table

-- DROP TABLE menu_cook;

CREATE TABLE menu_cook
(
    menu_cook_seq      VARCHAR(100) NOT NULL,
    title              VARCHAR(100),
    header             LONGTEXT,
    footer             MEDIUMTEXT(16777215),
    del_yn             VARCHAR(1),
    use_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    save_temp          VARCHAR(1),
    description        LONGTEXT,
    status             VARCHAR(20),
    CONSTRAINT `PRIMARY` PRIMARY KEY (menu_cook_seq)
);


-- test.menu_cook_step definition

-- Drop table

-- DROP TABLE menu_cook_step;

CREATE TABLE menu_cook_step
(
    menu_cook_step_seq VARCHAR(100) NOT NULL,
    content            LONGTEXT,
    use_yn             VARCHAR(1),
    step_order         VARCHAR(100),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    title              LONGTEXT,
    CONSTRAINT `PRIMARY` PRIMARY KEY (menu_cook_step_seq)
);


-- test.menu_role definition

-- Drop table

-- DROP TABLE menu_role;

CREATE TABLE menu_role
(
    menu_id       VARCHAR(100) NOT NULL,
    role_id       VARCHAR(100) NOT NULL,
    status        VARCHAR(100),
    menu_role_seq VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (menu_id, role_id)
);


-- test.notice definition

-- Drop table

-- DROP TABLE notice;

CREATE TABLE notice
(
    notice_seq         VARCHAR(255) NOT NULL,
    created_by         VARCHAR(255),
    created_date       DATETIME,
    del_yn             VARCHAR(255),
    last_modified_by   VARCHAR(255),
    last_modified_date DATETIME,
    content            VARCHAR(255),
    post_cd            VARCHAR(255),
    read_cnt           INT,
    title              VARCHAR(255),
    top_fix_cd         VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (notice_seq)
);


-- test.notification_mng definition

-- Drop table

-- DROP TABLE notification_mng;

CREATE TABLE notification_mng
(
    notification_seq   VARCHAR(100) NOT NULL,
    title              VARCHAR(4000),
    user_send_seq      VARCHAR(100),
    is_read            VARCHAR(1),
    user_read_seq      VARCHAR(100),
    content            VARCHAR(4000),
    url                VARCHAR(1000),
    type_cd            VARCHAR(100),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (notification_seq)
);


-- test.`position` definition

-- Drop table

-- DROP TABLE `position`;

CREATE TABLE `position`
(
    position_seq       VARCHAR(100) NOT NULL,
    code               VARCHAR(100),
    name               VARCHAR(100),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (position_seq)
);


-- test.qa definition

-- Drop table

-- DROP TABLE qa;

CREATE TABLE qa
(
    qa_seq             VARCHAR(100) NOT NULL,
    question           TEXT(65535),
    answer             TEXT(65535),
    question_date      DATETIME,
    answer_date        DATETIME,
    user_question      VARCHAR(100),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(1),
    temp_yn            VARCHAR(1),
    title              MEDIUMTEXT(16777215),
    user_answer        VARCHAR(100),
    status             VARCHAR(20),
    CONSTRAINT `PRIMARY` PRIMARY KEY (qa_seq)
);


-- test.staff_mng definition

-- Drop table

-- DROP TABLE staff_mng;

CREATE TABLE staff_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    created_by         VARCHAR(255),
    `date`             VARCHAR(255),
    del_yn             VARCHAR(255),
    email              VARCHAR(255),
    full_name          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    user_name          VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.sys_role definition

-- Drop table

-- DROP TABLE sys_role;

CREATE TABLE sys_role
(
    role_id      VARCHAR(100) NOT NULL,
    role_nm      VARCHAR(100),
    role_desc    VARCHAR(100),
    role_site_cd VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_id)
);


-- test.sys_user_role definition

-- Drop table

-- DROP TABLE sys_user_role;

CREATE TABLE sys_user_role
(
    role_id       VARCHAR(100) NOT NULL,
    user_id       VARCHAR(100) NOT NULL,
    user_role_seq VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_id, user_id)
);


-- test.user_mng definition

-- Drop table

-- DROP TABLE user_mng;

CREATE TABLE user_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    created_by         VARCHAR(255),
    `date`             VARCHAR(255),
    del_yn             VARCHAR(255),
    email              VARCHAR(255),
    full_name          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    user_name          VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.owner_mng definition

-- Drop table

-- DROP TABLE owner_mng;

CREATE TABLE owner_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    created_by         VARCHAR(255),
    `date`             VARCHAR(255),
    del_yn             VARCHAR(255),
    email              VARCHAR(255),
    full_name          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    user_name          VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.voucher definition

-- Drop table

-- DROP TABLE voucher;

CREATE TABLE voucher
(
    voucher_seq        VARCHAR(100) NOT NULL,
    type_cd            VARCHAR(100),
    food_store_seq     VARCHAR(100),
    quantity           DECIMAL(10, 0),
    start_date         DATETIME,
    end_date           DATETIME,
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_by         VARCHAR(100),
    created_date       DATETIME,
    last_modified_by   VARCHAR(100),
    last_modified_date DATETIME,
    use_policy         FLOAT,
    status_appr        VARCHAR(100),
    appr_date          DATETIME,
    appr_user          VARCHAR(100),
    value              DECIMAL(10, 0),
    CONSTRAINT `PRIMARY` PRIMARY KEY (voucher_seq)
);


-- test.voucher_user definition

-- Drop table

-- DROP TABLE voucher_user;

CREATE TABLE voucher_user
(
    voucher_user_seq   VARCHAR(100) NOT NULL,
    voucher_seq        VARCHAR(100),
    user_id            VARCHAR(100),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (voucher_user_seq)
);