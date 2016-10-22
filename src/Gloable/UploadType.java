package Gloable;

public enum UploadType {
	
	MP3("mp3"),MP4("mp4"),RMVB("rmvb"),TXT("txt"),XML("xml"),HTML("html"),JSP("jsp"),CSS("css"),JS("js"),DOC("doc");
	private String type;
	
	UploadType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
