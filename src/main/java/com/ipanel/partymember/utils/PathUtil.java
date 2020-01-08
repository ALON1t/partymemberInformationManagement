package com.ipanel.partymember.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author liyu
 * @date 2020/1/8 12:03
 * @description
 */
@UtilityClass
public class PathUtil {

    final static String webName = "partymemberInformationManagement";

    /**
     * @param absolutePath
     * @param mainSeparator
     * @return
     */
    public String toAbsolutePath(@NotNull String absolutePath, String mainSeparator) {
        Path path = Paths.get(absolutePath);
        String p = String.valueOf(path);
        if (StringUtils.isBlank(mainSeparator)) {
            return p;
        }
        return p.substring(0, p.indexOf("webName+\\") + 1) + mainSeparator + p.substring(p.indexOf("webName" + File.separator) + 1);
    }
}
