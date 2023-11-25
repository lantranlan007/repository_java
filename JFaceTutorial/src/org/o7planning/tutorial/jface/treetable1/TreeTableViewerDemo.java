package org.o7planning.tutorial.jface.treetable1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;
import org.o7planning.tutorial.jface.model.DataModel;
import org.eclipse.jface.viewers.TreeViewerColumn;

public class TreeTableViewerDemo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TreeTableViewerDemo window = new TreeTableViewerDemo();
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
		
		TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnNewColumn = treeViewerColumn.getColumn();
		trclmnNewColumn.setWidth(100);
		trclmnNewColumn.setText("Dept No");
		
		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnNewColumn_1 = treeViewerColumn_1.getColumn();
		trclmnNewColumn_1.setWidth(100);
		trclmnNewColumn_1.setText("Dept Name");
		
		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnNewColumn_2 = treeViewerColumn_2.getColumn();
		trclmnNewColumn_2.setWidth(100);
		trclmnNewColumn_2.setText("Emp No");
		
		TreeViewerColumn treeViewerColumn_3 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnNewColumn_3 = treeViewerColumn_3.getColumn();
		trclmnNewColumn_3.setWidth(100);
		trclmnNewColumn_3.setText("First Name");
		
		TreeViewerColumn treeViewerColumn_4 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnNewColumn_4 = treeViewerColumn_4.getColumn();
		trclmnNewColumn_4.setWidth(100);
		trclmnNewColumn_4.setText("Last Name");
		
		
		DeptEmpTreeTableCLProvider provider= new DeptEmpTreeTableCLProvider();
	    treeViewer.setContentProvider(provider);
	    treeViewer.setLabelProvider(provider);

		treeViewer.setInput(DataModel.getDepartments());
	}

}
