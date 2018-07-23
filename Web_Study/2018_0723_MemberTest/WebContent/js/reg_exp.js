/**
 * 
 */


//정규식 => 별도 js화일을 참조
var reg_tel = /^\d{3}-\d{3,4}-\d{4}$/;
var reg_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
var reg_jumin = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-8][0-9]{6}$/;
var reg_pwd = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
//가장 많이 사용되는 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
var reg_su = /^[1-9]{1}[0-9]{0,3}$/;
