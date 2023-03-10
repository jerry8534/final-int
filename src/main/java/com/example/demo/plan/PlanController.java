package com.example.demo.plan;

import com.example.demo.tourapi.TourAPIGetData;
import com.example.demo.tourapi.TourAPIJsonParsing;
import com.example.demo.tourapi.testVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PlanController {

    @Autowired
    PlanService planService;

    @RequestMapping("/plan/itemList/{region}")
    public ModelAndView itemList(@PathVariable String region) {
        ModelAndView mv = new ModelAndView();
        TourAPIGetData tourAPIGetData = new TourAPIGetData();
        String a = tourAPIGetData.getKeywordJsonData(region);
        TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
        List<String> b = tourAPIJsonParsing.getContentIdList(a);
        List<String> result = tourAPIGetData.getDetailJsonDataList(b);
        mv.addObject("result", result);
        mv.setViewName("main/itemlist");
        return mv;
    }

    @RequestMapping("/plan/itemList/{region}/{contentTypeId}")
    public ModelAndView itemListCat(@PathVariable String region, @PathVariable String contentTypeId) {
        ModelAndView mv = new ModelAndView();
        TourAPIGetData tourAPIGetData = new TourAPIGetData();
        String a = tourAPIGetData.getKeywordJsonData(region);
        TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
        List<String> b = tourAPIJsonParsing.getContentIdList(a);
        List<String> c = tourAPIGetData.getDetailJsonDataListByType(b, contentTypeId);
        List<testVo> result = tourAPIJsonParsing.getOutputList(c);
        mv.addObject("result", result);
        mv.setViewName("main/itemlist");
        return mv;
    }

    @RequestMapping("/plan/itemDetail/{contentId}")
    public ModelAndView itemDetail(@PathVariable String contentId) {
        ModelAndView mv = new ModelAndView();
        TourAPIGetData tourAPIGetData = new TourAPIGetData();
        String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
        TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
        testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
        mv.addObject("result", result2);
        mv.setViewName("main/itemdetail");
        return mv;
    }

    @RequestMapping("/plan/itemDetailModal/{contentId}")
    public ModelAndView itemDetailModal(@PathVariable String contentId) {
        ModelAndView mv = new ModelAndView();
        TourAPIGetData tourAPIGetData = new TourAPIGetData();
        String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
        TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
        testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
        mv.addObject("result", result2);
        mv.setViewName("main/itemdetailModal");
        return mv;
    }
}
