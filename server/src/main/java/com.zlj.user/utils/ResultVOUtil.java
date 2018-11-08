package com.zlj.user.utils;

import com.zlj.user.enums.ResultEnum;
import com.zlj.user.vo.ResultVO;

/**
 * @author tori
 * 2018/8/6 下午2:31
 */
public class ResultVOUtil {

    public static ResultVO success(Object obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(obj);
        return resultVO;
    }

    public static ResultVO success() {
        return ResultVOUtil.success(null);
    }

    public static ResultVO error(ResultEnum obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(obj.getCode());
        resultVO.setMsg(obj.getMessage());
        return resultVO;
    }
}
