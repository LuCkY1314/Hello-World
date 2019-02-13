
package android.databinding;
import com.example.chansiqing.databindingstudy.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 17;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.chansiqing.databindingstudy.R.layout.floor_binding_adapter_test:
                    return com.example.chansiqing.databindingstudy.databinding.FloorBindingAdapterTestBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.floor_list_test_floor:
                    return com.example.chansiqing.databindingstudy.databinding.FloorListTestFloorBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.activity_main:
                    return com.example.chansiqing.databindingstudy.databinding.ActivityMainBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.view_flipper_child:
                    return com.example.chansiqing.databindingstudy.databinding.ViewFlipperChildBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.floor_auto_adapter:
                    return com.example.chansiqing.databindingstudy.databinding.FloorAutoAdapterBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.list_item_list_floor:
                    return com.example.chansiqing.databindingstudy.databinding.ListItemListFloorBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.activity_main_frame:
                    return com.example.chansiqing.databindingstudy.databinding.ActivityMainFrameBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.activity_mix_list:
                    return com.example.chansiqing.databindingstudy.databinding.ActivityMixListBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.activity_complex_floor:
                    return com.example.chansiqing.databindingstudy.databinding.ActivityComplexFloorBinding.bind(view, bindingComponent);
                case com.example.chansiqing.databindingstudy.R.layout.floor_list_test_new:
                    return com.example.chansiqing.databindingstudy.databinding.FloorListTestNewBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 548174341: {
                if(tag.equals("layout/floor_binding_adapter_test_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.floor_binding_adapter_test;
                }
                break;
            }
            case -1475593543: {
                if(tag.equals("layout/floor_list_test_floor_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.floor_list_test_floor;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.activity_main;
                }
                break;
            }
            case 1015396937: {
                if(tag.equals("layout/view_flipper_child_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.view_flipper_child;
                }
                break;
            }
            case -1179539704: {
                if(tag.equals("layout/floor_auto_adapter_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.floor_auto_adapter;
                }
                break;
            }
            case -258792724: {
                if(tag.equals("layout/list_item_list_floor_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.list_item_list_floor;
                }
                break;
            }
            case -653116573: {
                if(tag.equals("layout/activity_main_frame_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.activity_main_frame;
                }
                break;
            }
            case -871361315: {
                if(tag.equals("layout/activity_mix_list_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.activity_mix_list;
                }
                break;
            }
            case 1367158339: {
                if(tag.equals("layout/activity_complex_floor_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.activity_complex_floor;
                }
                break;
            }
            case -1370883507: {
                if(tag.equals("layout/floor_list_test_new_0")) {
                    return com.example.chansiqing.databindingstudy.R.layout.floor_list_test_new;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"bgUrl"
            ,"contentUrl"
            ,"count"
            ,"imgUrl"
            ,"isNew"
            ,"item"
            ,"marginHorizon"
            ,"model"
            ,"name"
            ,"needColor"
            ,"presenter"
            ,"price"
            ,"showDefault"
            ,"text"
            ,"url"
            ,"url2"};
    }
}