package org.o7planning.tutorial.jface.tableviewer1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.o7planning.tutorial.jface.model.Article;
import org.o7planning.tutorial.jface.model.DataModel;
import org.eclipse.jface.viewers.TableViewerColumn;

public class TableViewerDemo {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TableViewerDemo window = new TableViewerDemo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		 		
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Article");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Author");
		
		ArticleTableCLProvider provider = new ArticleTableCLProvider();        
		tableViewer.setContentProvider(provider);        
		tableViewer.setLabelProvider(provider); 
		//One of the simplest causes of this problem is when the label provider 
		//is added BEFORE creating the columns. 
		//always see to it that the label provider is added afterwards!
		//An error has occurred. See error log for more details.
		//assertion failed: Column 0 has no label provider.

		// Set InputData for TableViewer.
				List<Article> articleList= DataModel.getArticles();
				tableViewer.setInput(articleList);
				
		

	}

}
