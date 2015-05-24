package de.netallied.functionblock.codeditor.java;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.text.SimpleJavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;

public class JavaSourceViewerConfig extends SimpleJavaSourceViewerConfiguration
{

  /**
   * Creates a new Java source viewer configuration for viewers in the given editor
   * using the given preference store, the color manager and the specified document partitioning.
   *
   * @param colorManager the color manager
   * @param preferenceStore the preference store, can be read-only
   * @param editor the editor in which the configured viewer(s) will reside, or <code>null</code> if none
   * @param partitioning the document partitioning for this configuration, or <code>null</code> for the default partitioning
   * @param configureFormatter <code>true</code> if a content formatter should be configured
   */
  public JavaSourceViewerConfig() 
  {
    super(JavaPlugin.getDefault().getJavaTextTools().getColorManager(), JavaPlugin.getDefault().getCombinedPreferenceStore(), null,  IJavaPartitions.JAVA_PARTITIONING, true);
  }

  public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) 
  {
    ContentAssistant assistant = new ContentAssistant();
    assistant.setContentAssistProcessor( new JavaCompletionProcessor(),IDocument.DEFAULT_CONTENT_TYPE);

    assistant.enableAutoActivation(true);
    assistant.setAutoActivationDelay(500);
    assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
    return assistant;
  }
  
}