package com.antiy.demo.designs.factory.t1;

/**
 * @author yinguohui
 */
public class ShapeFactory {

    private static final String CIRCLE = "CIRCLE";
    private static final String SQUARE = "SQUARE";
    /**
     * 功能描述 :使用 getShape 方法获取形状类型的对象
     *
     * @author ygh
     * @date 16:02
     */
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (CIRCLE.equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if (SQUARE.equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }
}