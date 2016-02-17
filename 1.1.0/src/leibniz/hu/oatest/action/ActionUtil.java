package leibniz.hu.oatest.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionUtil<T> extends ActionSupport implements ModelDriven<T>{
	private static final long serialVersionUID = 1904920961907881187L;
	//模型驱动
	private T model ;
	@Override
	public T getModel() {
		return model;
	}
	
	//得到范型的类型，并创建对应的Model对象
	@SuppressWarnings("rawtypes")
	private Class curClass;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ActionUtil(){
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.curClass = (Class) pt.getActualTypeArguments()[0];
			this.model = (T) this.curClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	//定义一些常用的Action返回值字符串
	public static final String LIST = "list";
	public static final String ADD_WEB = "addWeb";
	public static final String UPDATE_WEB = "updateWeb";
	public static final String JUMP_ACTION = "jumpAction";
	
	public String list = LIST;
	public String addWeb = ADD_WEB;
	public String updateWeb = UPDATE_WEB;
	public String jumpAction = JUMP_ACTION;
}
