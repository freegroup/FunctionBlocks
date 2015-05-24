package de.netallied.functionblock.util;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class IntegerPropertyGroupingDescriptor extends PropertyDescriptor
{
	private CellEditor editor;
	public IntegerPropertyGroupingDescriptor(Object id, String displayName, String category)
	{
		super(id, displayName);
		setCategory(category);
		setValidator(new ICellEditorValidator()
		{
			public String isValid(Object obj)
			{
				try
				{
					Integer.parseInt((String) obj);
				}
				catch (Exception ex)
				{
					return editor.getValue().toString() + " n'est pas un entier.";
				}
				return null;
			}
		});
	}

	public CellEditor createPropertyEditor(Composite parent)
	{
		editor = new TextCellEditor(parent);
		if(getValidator() != null)
			editor.setValidator(getValidator());
		return editor;
	}
}