package names;

public class HtmlUtil {

    public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) throws Exception {

        boolean isTestPage = pageData.hasAtributte("Test");

        if(isTestPage) {

            WikiPage testPage = pageData.getWikiPage();
            StringBuffer newPageContent = new StringBuffer();

            includeSetupPages(testPage, newPageContent, isSuite);
            newPageContent.append(pageData.getContent());

            includeTeardownPages(testPage, newPageContent, isSuite);
            pageData.setContent(newPageContent.toString());
        }
    }


    // this example is more short then other, more simple is better
    // TO RenderPageWithSetupsAndTeardowns, we check to see whether the page is a test page
    //and if so, we include the setups and teardowns. In either case we render the page in
    //HTML.
    public static String renderPageWithSetupsAndTearDowns(PageData pageData, boolean isSuite) throws Exception {

        if(isTestPage(pageData)) {

            includeSetupAndTeardownPages(pageData, isSuite);

            return pageData.getHtml();
        }
    }

}
