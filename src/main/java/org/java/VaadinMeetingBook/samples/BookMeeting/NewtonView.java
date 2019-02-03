package org.java.VaadinMeetingBook.samples.BookMeeting;

import java.util.List;



import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Version;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class NewtonView extends CssLayout implements View {
	


	  public static final String VIEW_NAME = "Meeting view";
	
	

	private NewtonGrid grid;


	private NewtonGridForm form;

	private NewtonCrudLogic logic = new NewtonCrudLogic(this);


	private TextField filter;

	private Button newProduct;

	public NewtonView() {

	
		form =  new NewtonGridForm(logic);

		grid= new NewtonGrid();
 
		grid.asSingleSelect().addValueChangeListener
		
		(event -> logic.rowSelected(event.getValue()));


		setSizeFull();

		addStyleName("crud-view");

		HorizontalLayout layout = createTopBar();

		VerticalLayout gridlayout = new VerticalLayout();

		gridlayout.addComponent(layout);

		gridlayout.addComponent(grid);

		gridlayout.setSizeFull();

		gridlayout.setExpandRatio(grid, 1);



		gridlayout.setStyleName("curd-main-layout");

		grid.setSizeFull();

		addComponent(gridlayout); 

//		Cluster  = Cluster.builder().addContactPoint(host).build();
//
//		Connect = cluster.connect();
//
//		Select query  = QueryBuilder.Select().all().from(keyspace ,"hr_nenchomgmt_newtonview");
//
//		Resultset asdf = connection.execute(query);

//		List<NewtonGridProduct> slist = new ArrayList<NewtonGridProduct>();
//
//		NewtonGridProduct entity = new NewtonGridProduct();
//
//		entity.setDate(row.getString("date"));
//
//		entity.setMeetingRoom(row.getString("Meeting room"));
//
//		samplelist.add(entity);
//	});
//
//	connection.close();
//	cluster.close();
//	grid.setItems(samplelist);
//
//
		logic.init();



}


public HorizontalLayout createTopBar() {

	filter = new TextField();

	filter.setStyleName("filter_textfield");

	

	newProduct = new Button("new Product");

	

	  newProduct.addStyleName(ValoTheme.BUTTON_PRIMARY);
      newProduct.setIcon(FontAwesome.PLUS_CIRCLE);

	HorizontalLayout topLayout = new HorizontalLayout();

	topLayout.setWidth("100%");

	topLayout.addComponent(filter);

	topLayout.addComponent(newProduct);

	topLayout.setComponentAlignment(filter,Alignment.MIDDLE_LEFT);


	topLayout.setExpandRatio(filter , 1);

	topLayout.setStyleName("top-bar");

	return topLayout;

}

public void clearSelection() {

	grid.getSelectionModel().deselectAll();

}

ViewChangeListener viewlistener = new ViewChangeListener() {



	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void afterViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		System.out.println("");
	}

};




public void editProduct(MeetingFields product) {
	if (product != null) {
		form.addStyleName("visible");
		form.setEnabled(true);
	} else {
		form.removeStyleName("visible");
		form.setEnabled(false);
	}
	form.editProduct(product);
}

@Override
public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	
}


public void removeProduct(MeetingFields product) {
	// TODO Auto-generated method stub
	
}


public void refreshProduct(MeetingFields product) {
	// TODO Auto-generated method stub
	
}	



}



