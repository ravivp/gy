package core.context;

import core.browser.Browser;
import jt.pages.*;

public class Apps {


   public HomePage homePage=new HomePage(Browser.getDriver());
    public FindStore findStore=new FindStore(Browser.getDriver());
    public FindTire findTire=new FindTire(Browser.getDriver());
    public PlpPage plpPage=new PlpPage(Browser.getDriver());
    public MiniCart miniCart=new MiniCart(Browser.getDriver());
    public Cart cart=new Cart(Browser.getDriver());
    public FooterSection footerSection=new FooterSection(Browser.getDriver());

}
