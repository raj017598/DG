package munni.priyanka.dg;

public class FetchBook {
    String name, url, image_url;
    public FetchBook() { }
    public FetchBook(String name, String url, String image_url) {
        this.name = name;
        this.url = url;
        this.image_url = image_url; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
