package leibniz.hu.oatest.domain;

import java.util.Date;

public class Version {
	private Long vid;
	private Long version;//版本号
	private Date updatetime;
	private String title;
	private String content;
	//多对一关系
	private Kynamic kynamic;

	//getter & setter
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Kynamic getKynamic() {
		return kynamic;
	}
	public void setKynamic(Kynamic kynamic) {
		this.kynamic = kynamic;
	}
}
