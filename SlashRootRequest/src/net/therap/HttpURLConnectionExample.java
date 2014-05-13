package net.therap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/12/14
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        //System.out.println("Testing 1 - Send Http GET request");
        //http.sendGet();

        System.out.println("\nTesting 2 - Send Http POST request");
        http.sendPost();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "http://www.slashroot.in:80/system/ajax";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Accept-Encoding", "gzip, deflate");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
        con.setRequestProperty("Referer", "http://www.slashroot.in/secure-shell-how-does-ssh-work");
        con.setRequestProperty("Content-length", "12261");
        con.setRequestProperty("Cookie", "");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("Pragma", "no-cache");
        con.setRequestProperty("Cache-Control", "no-cache");

        String urlParameters = "vote=100&form_build_id=form-DBpS3Yeirwo5I_ZV3eUrKUgtHJ7hoK05NlVJSCFx_K0&form_id=fivestar_custom_widget&_triggering_element_name=vote&ajax_html_ids%5B%5D=LR1&ajax_html_ids%5B%5D=twttrHubFrameSecure&ajax_html_ids%5B%5D=twttrHubFrame&ajax_html_ids%5B%5D=hellobar-wrapper&ajax_html_ids%5B%5D=hellobar-container&ajax_html_ids%5B%5D=hellobar-logo&ajax_html_ids%5B%5D=hellobar-shadow&ajax_html_ids%5B%5D=cboxOverlay&ajax_html_ids%5B%5D=colorbox&ajax_html_ids%5B%5D=cboxWrapper&ajax_html_ids%5B%5D=cboxTopLeft&ajax_html_ids%5B%5D=cboxTopCenter&ajax_html_ids%5B%5D=cboxTopRight&ajax_html_ids%5B%5D=cboxMiddleLeft&ajax_html_ids%5B%5D=cboxContent&ajax_html_ids%5B%5D=cboxLoadedContent&ajax_html_ids%5B%5D=cboxLoadingOverlay&ajax_html_ids%5B%5D=cboxLoadingGraphic&ajax_html_ids%5B%5D=cboxTitle&ajax_html_ids%5B%5D=cboxCurrent&ajax_html_ids%5B%5D=cboxNext&ajax_html_ids%5B%5D=cboxPrevious&ajax_html_ids%5B%5D=cboxSlideshow&ajax_html_ids%5B%5D=cboxClose&ajax_html_ids%5B%5D=cboxMiddleRight&ajax_html_ids%5B%5D=cboxBottomLeft&ajax_html_ids%5B%5D=cboxBottomCenter&ajax_html_ids%5B%5D=cboxBottomRight&ajax_html_ids%5B%5D=skip-link&ajax_html_ids%5B%5D=page-wrapper&ajax_html_ids%5B%5D=page&ajax_html_ids%5B%5D=header&ajax_html_ids%5B%5D=logo&ajax_html_ids%5B%5D=mobile-logo&ajax_html_ids%5B%5D=block-multiblock-1&ajax_html_ids%5B%5D=search-block-form--2&ajax_html_ids%5B%5D=edit-search-block-form--4&ajax_html_ids%5B%5D=edit-actions--3&ajax_html_ids%5B%5D=edit-submit--3&ajax_html_ids%5B%5D=block-menu-menu-news-categories&ajax_html_ids%5B%5D=main-wrapper&ajax_html_ids%5B%5D=main&ajax_html_ids%5B%5D=content&ajax_html_ids%5B%5D=main-content&ajax_html_ids%5B%5D=page-title&ajax_html_ids%5B%5D=block-block-23&ajax_html_ids%5B%5D=block-widgets-s-addthis-share&ajax_html_ids%5B%5D=widgets-element-addthis-share&ajax_html_ids%5B%5D=widgets-element-socialmedia_addthis-tweet&ajax_html_ids%5B%5D=twitter-widget-0&ajax_html_ids%5B%5D=widgets-element-socialmedia_addthis-facebook-like&ajax_html_ids%5B%5D=widgets-element-socialmedia_addthis-google-plusone&ajax_html_ids%5B%5D=___plusone_0&ajax_html_ids%5B%5D=I0_1399879390962&ajax_html_ids%5B%5D=widgets-element-socialmedia_addthis-addthis-counter&ajax_html_ids%5B%5D=_atssh&ajax_html_ids%5B%5D=_atssh486&ajax_html_ids%5B%5D=block-system-main&ajax_html_ids%5B%5D=node-185&ajax_html_ids%5B%5D=highlighter_578770&ajax_html_ids%5B%5D=highlighter_177985&ajax_html_ids%5B%5D=highlighter_94487&ajax_html_ids%5B%5D=highlighter_181344&ajax_html_ids%5B%5D=block-block-17--2&ajax_html_ids%5B%5D=highlighter_687231&ajax_html_ids%5B%5D=highlighter_717806&ajax_html_ids%5B%5D=fivestar-custom-widget&ajax_html_ids%5B%5D=edit-vote--14&ajax_html_ids%5B%5D=edit-fivestar-submit&ajax_html_ids%5B%5D=fe96955e09437e&ajax_html_ids%5B%5D=comments&ajax_html_ids%5B%5D=comment-134&ajax_html_ids%5B%5D=comment-135&ajax_html_ids%5B%5D=comment-153&ajax_html_ids%5B%5D=comment-152&ajax_html_ids%5B%5D=comment-154&ajax_html_ids%5B%5D=comment-476&ajax_html_ids%5B%5D=comment-492&ajax_html_ids%5B%5D=comment-589&ajax_html_ids%5B%5D=comment-697&ajax_html_ids%5B%5D=comment-form&ajax_html_ids%5B%5D=edit-name&ajax_html_ids%5B%5D=edit-subject&ajax_html_ids%5B%5D=edit-comment-body&ajax_html_ids%5B%5D=comment-body-add-more-wrapper&ajax_html_ids%5B%5D=edit-comment-body-und-0-value&ajax_html_ids%5B%5D=edit-comment-body-und-0-format&ajax_html_ids%5B%5D=edit-comment-body-und-0-format--2&ajax_html_ids%5B%5D=edit-comment-body-und-0-format-help&ajax_html_ids%5B%5D=edit-comment-body-und-0-format-guidelines&ajax_html_ids%5B%5D=edit-mollom-captcha&ajax_html_ids%5B%5D=edit-mollom-homepage&ajax_html_ids%5B%5D=edit-actions&ajax_html_ids%5B%5D=edit-submit&ajax_html_ids%5B%5D=edit-preview&ajax_html_ids%5B%5D=block-similarterms-all&ajax_html_ids%5B%5D=block-search-form&ajax_html_ids%5B%5D=search-block-form&ajax_html_ids%5B%5D=edit-search-block-form--2&ajax_html_ids%5B%5D=edit-actions--2&ajax_html_ids%5B%5D=edit-submit--2&ajax_html_ids%5B%5D=block-block-7&ajax_html_ids%5B%5D=mc_embed_signup&ajax_html_ids%5B%5D=mc-embedded-subscribe-form&ajax_html_ids%5B%5D=mce-EMAIL&ajax_html_ids%5B%5D=mce-FNAME&ajax_html_ids%5B%5D=mce-MMERGE3&ajax_html_ids%5B%5D=mce-responses&ajax_html_ids%5B%5D=mce-error-response&ajax_html_ids%5B%5D=mce-success-response&ajax_html_ids%5B%5D=mc-embedded-subscribe&ajax_html_ids%5B%5D=block-views-most-popular-today-block&ajax_html_ids%5B%5D=block-block-21&ajax_html_ids%5B%5D=block-views-most-commented-block&ajax_html_ids%5B%5D=block-views-top-rated-articles-block&ajax_html_ids%5B%5D=block-block-4&ajax_html_ids%5B%5D=footer&ajax_html_ids%5B%5D=block-block-12&ajax_html_ids%5B%5D=block-block-3&ajax_html_ids%5B%5D=block-block-2&ajax_html_ids%5B%5D=block-block-6&ajax_html_ids%5B%5D=mc_embed_signup&ajax_html_ids%5B%5D=mc-embedded-subscribe-form&ajax_html_ids%5B%5D=mce-EMAIL&ajax_html_ids%5B%5D=mce-responses&ajax_html_ids%5B%5D=mce-error-response&ajax_html_ids%5B%5D=mce-success-response&ajax_html_ids%5B%5D=mc-embedded-subscribe&ajax_html_ids%5B%5D=block-views-recent-posts-block&ajax_html_ids%5B%5D=block-views-last-viewed-block&ajax_html_ids%5B%5D=block-block-1&ajax_html_ids%5B%5D=fb-root&ajax_html_ids%5B%5D=fb_xdm_frame_http&ajax_html_ids%5B%5D=fb_xdm_frame_https&ajax_html_ids%5B%5D=oauth2relay320509185&ajax_page_state%5Btheme%5D=news_center&ajax_page_state%5Btheme_token%5D=-mf5UQXUEZ52D_L-W8-dBfLy9qX8DcZd-mxbOiHA-jY&ajax_page_state%5Bcss%5D%5Bmodules%2Fsystem%2Fsystem.base.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fsystem%2Fsystem.menus.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fsystem%2Fsystem.messages.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fsystem%2Fsystem.theme.css%5D=1&ajax_page_state%5Bcss%5D%5Bmisc%2Fui%2Fjquery.ui.core.css%5D=1&ajax_page_state%5Bcss%5D%5Bmisc%2Fui%2Fjquery.ui.theme.css%5D=1&ajax_page_state%5Bcss%5D%5Bmisc%2Fui%2Fjquery.ui.button.css%5D=1&ajax_page_state%5Bcss%5D%5Bmisc%2Fui%2Fjquery.ui.resizable.css%5D=1&ajax_page_state%5Bcss%5D%5Bmisc%2Fui%2Fjquery.ui.dialog.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fcomment%2Fcomment.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Ffield%2Ftheme%2Ffield.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fmollom%2Fmollom.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fnode%2Fnode.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fsearch%2Fsearch.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fuser%2Fuser.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Fyoutube%2Fcss%2Fyoutube.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Fviews%2Fcss%2Fviews.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fcodefilter%2Fcodefilter.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Fcolorbox%2Fstyles%2Fstockholmsyndrome%2Fcolorbox_stockholmsyndrome.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Fctools%2Fcss%2Fctools.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fgeshifilter%2Fgeshifilter.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fjquerymenu%2Fjquerymenu.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Flibraries%2Fsyntaxhighlighter_3.0.83%2Fstyles%2FshCore.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Flibraries%2Fsyntaxhighlighter_3.0.83%2Fstyles%2FshThemeMDUltra.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Fsyntaxhighlighter_insert%2Fsyntaxhighlighter_insert_wysiwyg%2Fsyntaxhighlighter_insert_wysiwyg.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Ffivestar%2Fwidgets%2Foutline%2Foutline.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Fwidgets%2Fwidgets.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fmodules%2Ffivestar%2Fcss%2Ffivestar.css%5D=1&ajax_page_state%5Bcss%5D%5Bmodules%2Ffilter%2Ffilter.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fblueprint%2Fscreen.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fwireframes.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Flayout-fixed.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fpage-backgrounds.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Ftabs.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fpages.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fblocks.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fnavigation.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fviews-styles.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fnodes.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fcomments.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fforms.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Ffields.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fmobile-portrait-layout.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fnews_center.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fblueprint%2Fprint.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fmobile-landscape-layout.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Ftablet-layout.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fscreen-layout.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fblueprint%2Fie.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fie-mobile-landscape-layout.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fie-tablet-layout.css%5D=1&ajax_page_state%5Bcss%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fcss%2Fie-screen-layout.css%5D=1&ajax_page_state%5Bjs%5D%5B0%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fmodules%2Fsyntaxhighlighter%2Fsyntaxhighlighter.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fjquery.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fjquery.once.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fdrupal.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.core.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.widget.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmodules%2Fsyntaxhighlighter_insert%2Fsyntaxhighlighter_insert.utils.js%5D=1&ajax_page_state%5Bjs%5D%5Bmodules%2Fsyntaxhighlighter_insert%2Fsyntaxhighlighter_insert.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.button.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.mouse.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.draggable.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.position.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.resizable.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fui%2Fjquery.ui.dialog.min.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fmodules%2Fviews%2Fjs%2Fjquery.ui.dialog.patch.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fjquery.cookie.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fjquery.form.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fform.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fajax.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Flibraries%2Fsyntaxhighlighter_3.0.83%2Fscripts%2FshCore.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Flibraries%2Fsyntaxhighlighter_3.0.83%2Fscripts%2FshAutoloader.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fdefault%2Ffiles%2Fsyntaxhighlighter.autoloader.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Flibraries%2Fcolorbox%2Fcolorbox%2Fjquery.colorbox-min.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fmodules%2Fcolorbox%2Fjs%2Fcolorbox.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fmodules%2Fcolorbox%2Fstyles%2Fstockholmsyndrome%2Fcolorbox_stockholmsyndrome.js%5D=1&ajax_page_state%5Bjs%5D%5Bmodules%2Fjquerymenu%2Fjquerymenu.js%5D=1&ajax_page_state%5Bjs%5D%5Bmodules%2Fgoogle_analytics%2Fgoogleanalytics.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Fprogress.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fmodules%2Ffivestar%2Fjs%2Ffivestar.ajax.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fmodules%2Ffivestar%2Fjs%2Ffivestar.js%5D=1&ajax_page_state%5Bjs%5D%5Bmisc%2Ftextarea.js%5D=1&ajax_page_state%5Bjs%5D%5Bmodules%2Ffilter%2Ffilter.js%5D=1&ajax_page_state%5Bjs%5D%5Bmodules%2Fmollom%2Fmollom.js%5D=1&ajax_page_state%5Bjs%5D%5Bsites%2Fall%2Fthemes%2Fnews_center%2Fjs%2Fnews_center.js%5D=1";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        try {
            File file = new File("/home/sanjoy.saha/Drive/respose_from_slash_root.html");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(response.toString());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}