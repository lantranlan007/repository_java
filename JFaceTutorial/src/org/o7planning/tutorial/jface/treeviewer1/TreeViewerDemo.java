package org.o7planning.tutorial.jface.treeviewer1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;
import org.o7planning.tutorial.jface.model.DataModel;
import org.eclipse.jface.viewers.TreeViewerColumn;

public class TreeViewerDemo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TreeViewerDemo window = new TreeViewerDemo();
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
		
		AppMenuTreeCLProvider provider= new AppMenuTreeCLProvider();
	    treeViewer.setContentProvider(provider);
	    treeViewer.setLabelProvider(provider);
	     
	      tree.setLinesVisible(true);
	      tree.setHeaderVisible(true);
	     
	      treeViewer.setInput(DataModel.getAppMenus());
	}

}
