package com.TTN.AmazonWebsite.Controller;

import com.TTN.AmazonWebsite.Entity.MetaData.CategoryMetadataFields;
import com.TTN.AmazonWebsite.Entity.Product.Category;
import com.TTN.AmazonWebsite.DaoService.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    @PostMapping("/addmetadata")
    public String addMetaField(@RequestParam("field")String  field){
        return categoryDao.addMetaDataField(field);
    }

    @GetMapping("/findallmetadata")
    public List<CategoryMetadataFields> find(){
        return categoryDao.viewMetadataField();
    }

    @PostMapping("/addcategory")
    public String addCategory(@RequestParam("category") String category){
        return categoryDao.AddCategory(category);
    }

    @GetMapping("/categoryfindByid")
    public Optional<Category> finder(@RequestParam("id") int id){
        return categoryDao.findCategory(id);
    }

    @GetMapping("/listofcategory")
    public List<Category> finnderList(){
        return categoryDao.findList();
    }

    @PutMapping("/updatecategory")
    public String updatercategory(@RequestParam("id") int  id,@RequestParam("newcategory") String newcategory){
        return categoryDao.CategoryUpdate(id,newcategory);
    }

    @PostMapping("/metadataforcategory")
    public String addmetadata(@RequestParam("categoryid") int categoryid, @RequestParam("metafieldid")
          int  metafieldid,@RequestParam("fieldvalue") String fieldvalue){
        return categoryDao.metaDataForCategory(categoryid,metafieldid,fieldvalue);
    }



    @PutMapping("/updatevaluesforfield")
    public String updatemetadata(@RequestParam("categoryid") int categoryid, @RequestParam("metafieldid")
            int  metafieldid,@RequestParam("fieldid") int fieldid,@RequestParam("fieldvalue") String fieldvalue){
        return categoryDao.updateMetaDataValuesForField(categoryid,metafieldid,fieldid,fieldvalue);
    }
}
