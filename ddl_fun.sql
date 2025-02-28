CREATE FUNCTION fn_get_code_name(p_cd_id VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE v_CODE_NAME VARCHAR(255) DEFAULT NULL;

    IF p_cd_id IS NULL THEN
        SET v_CODE_NAME = p_cd_id;
ELSE
SELECT cd_key
FROM code_mng
WHERE cd_id = p_cd_id
    LIMIT 1
INTO @temp_value;

SET v_CODE_NAME = @temp_value;
END IF;

RETURN v_CODE_NAME;
END
