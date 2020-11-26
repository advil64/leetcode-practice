
class BrowserHistory {

    WebNode homePage;
    WebNode curr;

    public BrowserHistory(String homepage) {
        homePage = new WebNode(homepage, null);
        curr = homePage;
    }
    
    public void visit(String url) {
        curr.nextNode = new WebNode(url, curr);
        curr = curr.nextNode;
    }
    
    public String back(int steps) {
        for(int i = steps; i > 0; i--){
            if(curr != homePage){
                curr = curr.prevNode;
            } else{
                break;
            }
        }
        return curr.myPage;
    }
    
    public String forward(int steps) {
        for(int i = 0; i < steps; i++){
            if(curr.nextNode != null){
                curr = curr.nextNode;
            } else{
                break;
            }
        }
        return curr.myPage;
    }
}

class WebNode{

    String myPage;
    WebNode nextNode;
    WebNode prevNode;

    public WebNode(String webPage, WebNode prev){
        myPage = webPage;
        prevNode = prev;
        nextNode = null;
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */