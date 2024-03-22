package com.lxj.aspect;

/**
 * @author Xingjing.Li
 * @since 2023/3/27
 */
//@Aspect
//@Component
//@Order(10)
//@Slf4j
public class DataPermissionAspect {

//    @Pointcut("@annotation(com.talebase.common.web.annotation.DataPermission)")
//    public void dataPermissionPointCut() {}
//
//    @Before("dataPermissionPointCut()")
//    public void injectBefore(JoinPoint point) {
//        final Object[] args = point.getArgs();
//        final MethodSignature methodSign = (MethodSignature) point.getSignature();
//        log.info("[权限]切入点{}, args=>{}", methodSign.getName(), args);
//        try {
//            ServiceHeader requestHeader = UserCommonContext.getRequestHeader();
//            Boolean superCustomerFlag = requestHeader.getSuperCustomerFlag();
//            if (superCustomerFlag != null && superCustomerFlag){
//                return;
//            }
//            Map<Integer, List<Integer>> permissionUserMap = requestHeader.getPermissionUserMap();
//            //获取注解的值
//            DataPermission annotation = methodSign.getMethod().getAnnotation(DataPermission.class);
//            Class<?> clazz = annotation.clazz();
//            Object o = clazz.newInstance();
//            String fieldName = annotation.fieldName();
//            //注入值
//            for (Object arg : args) {
//                Class<?> argClass = arg.getClass();
//                if (argClass.equals(o.getClass())){
//                    //获得前端权限code
//                    Field permissionCodeField = argClass.getDeclaredField("permissionCode");
//                    permissionCodeField.setAccessible(true);
//                    Object obj = permissionCodeField.get(arg);
//                    if (obj != null) {
//                        String permissionCode = obj.toString();
//                        if (StringUtils.isNotBlank(permissionCode)) {
//                            String[] s = permissionCode.split("_");
//                            String temp = s[s.length - 1];
//                            if ('P' == temp.charAt(0)) {
//                                temp = temp.substring(1, temp.length());
//                            }
//                            Integer code = Integer.parseInt(temp);
//                            Field field = argClass.getDeclaredField(fieldName);
//                            log.info("[权限]injection field name: {}, code: {}", field.getName(), code);
//                            field.setAccessible(true);
//                            List<Integer> userIdList = permissionUserMap.get(code);
//                            if (CollectionUtils.isNotEmpty(userIdList)) {
//                                field.set(arg, userIdList);
//                            }else{
//                                field.set(arg, Arrays.asList(-1));
//                            }
//                        }
//                    }
//                } else if (annotation.subClazz()){
//                    Field declaredField = argClass.getDeclaredField(annotation.subClazzFieldName());
//                    declaredField.setAccessible(true);
//                    Object subObj = declaredField.get(arg);
//                    Class<?> type = declaredField.getType();
//                    log.info("[权限]注入类型{}",type.getName());
//                    if (type.equals(o.getClass())){
//                        //获得前端权限code
//                        Field permissionCodeField = type.getDeclaredField("permissionCode");
//                        permissionCodeField.setAccessible(true);
//                        Object obj = permissionCodeField.get(subObj);
//                        if (obj != null) {
//                            String permissionCode = obj.toString();
//                            log.info("[权限]permissionCode:{}", permissionCode);
//                            if (StringUtils.isNotBlank(permissionCode)) {
//                                String[] s = permissionCode.split("_");
//                                String temp = s[s.length - 1];
//                                if ('P' == temp.charAt(0)) {
//                                    temp = temp.substring(1, temp.length());
//                                }
//                                Integer code = Integer.parseInt(temp);
//                                Field field = type.getDeclaredField(fieldName);
//                                log.info("[权限]injection field name: {}, code: {}", field.getName(), code);
//                                field.setAccessible(true);
//                                List<Integer> userIdList = permissionUserMap.get(code);
//                                field.set(subObj, userIdList);
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            //TODO 异常是抛出不让查还是让用户正常查询未知
//            log.warn("[权限]异常 ex=>", ex);
//        }
//    }
}
