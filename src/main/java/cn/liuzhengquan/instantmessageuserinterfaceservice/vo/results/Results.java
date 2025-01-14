package cn.liuzhengquan.instantmessageuserinterfaceservice.vo.results;


import cn.liuzhengquan.instantmessageuserinterfaceservice.entity.Result;
import cn.liuzhengquan.instantmessageuserinterfaceservice.enums.ResultsEnum;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: Results
 * @Author: 刘政权
 * @AuthorEmail: liuzhengquanmail@163.com
 * @AuthorWebsite: liuzhengquan.cn
 * @Date: 2023-09-04 9:16
 * @Description TODO
 * @SourceCodeCopyrightReserved(c)：刘政权
 */
public class Results<T> {

    /**
     * 自定义 生成结果 0 Parameter
     *
     * @param status  状态码
     * @param message 信息
     * @param data    数据
     * @return Result
     */
    public static <T> Result buildResults(int status, String message, T data) {
        Result result = new Result();
        result.setStatus(status);
        result.setMessage(message);
        String jsonString = JSONObject.toJSONString(data);
        if (jsonString.startsWith("\"") && jsonString.endsWith("\"")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1);
        }
        result.setData(jsonString);
        return result;
    }


    /**
     * 生成成功结果 3 Parameter
     *
     * @param status  状态码
     * @param message 信息
     * @param data    数据
     * @return Result
     */
    public static <T> Result success(int status, String message, T data) {
        return buildResults(status, message, data);
    }


    /**
     * 生成成功结果 2 Parameter
     *
     * @param status  状态码
     * @param message 信息
     * @return Result
     */
    public static Result success(int status, String message) {
        return buildResults(status, message, true);
    }


    /**
     * 生成成功结果 1 Parameter
     *
     * @param data 数据
     * @return Result
     */
    public static <T> Result success(T data) {
        return buildResults(ResultsEnum.SUCCESS_STATUS_CODE, ResultsEnum.SUCCESS_MESSAGE, data);
    }

    /**
     * 生成成功结果 0 Parameter
     *
     * @return Result
     */
    public static <T> Result success() {
        return (Result) success(true);
    }



    /**
     * 生成失败结果 3 Parameter
     *
     * @param status  状态码
     * @param message 信息
     * @param data    数据
     * @return Result
     */
    public static <T> Result error(int status, String message, T data) {
        return buildResults(status, message, data);
    }

    /**
     * 生成失败结果 2 Parameter
     *
     * @param status  状态码
     * @param message 信息
     * @return Result
     */
    public static Result error(int status, String message) {
        return buildResults(status, message, false);
    }


    /**
     * 生成失败结果 1 Parameter
     *
     * @param data 数据
     * @return Result
     */
    public static <T> Result error(T data) {
        return buildResults(ResultsEnum.FAIL_STATUS_CODE, ResultsEnum.FAIL_MESSAGE, data);
    }


    /**
     * 生成失败结果 0 Parameter
     *
     * @return Result
     */
    public static Result error() {
        return buildResults(ResultsEnum.FAIL_STATUS_CODE, ResultsEnum.FAIL_MESSAGE, false);
    }
}