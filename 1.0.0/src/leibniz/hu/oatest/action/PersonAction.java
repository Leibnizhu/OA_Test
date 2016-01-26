package leibniz.hu.oatest.action;

import org.apache.struts2.ServletActionContext;

import leibniz.hu.oatest.domain.Person;
import leibniz.hu.oatest.service.PersonService;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{
	private PersonService ps;

	public PersonService getPs() {
		return ps;
	}

	public void setPs(PersonService ps) {
		this.ps = ps;
	}
	
	public String save(){
			Person p =new Person();
			p.setPname("Jucy");
			this.ps.savePerson(p);
			return "index";
	}
	
	public String get(){
		Person p = this.ps.getPersonById(2L);
		ServletActionContext.getRequest().setAttribute("person", p);
		return "index";
	}
}
