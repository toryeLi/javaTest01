package dao;

import com.entity.Items;
import util.handler.HandlerTemplate;
import util.handler.mysql.MySqlTemplateHandler;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    HandlerTemplate template=new MySqlTemplateHandler();
    /**
     * 获得所有的商品信息
     * @return
     */
    public List<Items> getAllItems(){
        List<Items> items1 = template.queryForList(Items.class);
        return items1;
    }

    /**
     * 根据商品编号获得商品资料
     * @param id
     * @return
     */
    public Items getItemsById(int id){
        return template.queryForObject(Items.class,id);
    }
    public ArrayList<Items> getViewList(String list){
        System.out.println("list:" + list);
        ArrayList<Items> itemList=new ArrayList<>();
        int count=5;//每次返回5条数据
        if (list != null && list.length()>0) {
            String[] arr = list.split(",");
            System.out.println("arr.length=" + arr.length);
            //如果商品记录大于等于5条
            if (arr.length>=5) {
                for (int i = arr.length - 1; i >=arr.length-count; i--) {
                    itemList.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    itemList.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            return itemList;
        }else {
            return null;
        }
    }
}
