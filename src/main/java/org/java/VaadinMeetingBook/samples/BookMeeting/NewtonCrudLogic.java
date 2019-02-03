package org.java.VaadinMeetingBook.samples.BookMeeting;



import java.io.Serializable;

import org.java.VaadinMeetingBook.MyUI;

import com.vaadin.server.Page;

/**
 * This class provides an interface for the logical operations between the CRUD
 * view, its parts like the product editor form and the data source, including
 * fetching and saving products.
 *
 * Having this separate from the view makes it easier to test various parts of
 * the system separately, and to e.g. provide alternative views for the same
 * data.
 */
public class NewtonCrudLogic implements Serializable {

    private NewtonView view;

    public NewtonCrudLogic(NewtonView simpleCrudView) {
        view = simpleCrudView;
    }

    public void init() {
     
        // Hide and disable if not admin
//       if (!MyUI.get().getAccessControl().isUserInRole("admin")) {
//           view.setNewProductEnabled(false);
//       }

     
    }

    public void cancelProduct() {
        setFragmentParameter("");
        view.clearSelection();
        view.editProduct(null);
    }
    
  private void setFragmentParameter(String productId) {
  String fragmentParameter;
  if (productId == null || productId.isEmpty()) {
      fragmentParameter = "";
  } else {
      fragmentParameter = productId;
  }

  Page page = MyUI.get().getPage();
//  page.setUriFragment(
//          "!" + NewtonView.VIEW_NAME + "/" + fragmentParameter,
//          false);
  
  
}

    /**
     * Update the fragment without causing navigator to change view
     */
  
    public void saveProduct(MeetingFields product) {
//        view.showSaveNotification(product. + " ("
//                + product.getId() + ") updated");
        view.clearSelection();
        view.editProduct(null);
        view.refreshProduct(product);
        setFragmentParameter("");
    }

    public void deleteProduct(MeetingFields product) {
////        DataService.get().deleteProduct(product.getId());
//        view.showSaveNotification(product.getProductName() + " ("
//                + product.getId() + ") removed");

        view.clearSelection();
        view.editProduct(null);
        view.removeProduct(product);
        setFragmentParameter("");
    }

    public void editProduct(MeetingFields product) {
        if (product == null) {
            setFragmentParameter("");
        } else {
            //setFragmentParameter(product.getId() + "");
        }
        view.editProduct(product);
    }

//    public void newProduct() {
//        view.clearSelection();
//        setFragmentParameter("new");
//        view.editProduct(new Product());
//    }

    public void rowSelected(MeetingFields product) {
//        if (MyUI.get().getAccessControl().isUserInRole("admin")) {
//            view.editProduct(product);
//        }
    	
    	
    }
}
