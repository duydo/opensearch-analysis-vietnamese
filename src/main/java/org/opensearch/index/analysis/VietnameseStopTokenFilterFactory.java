
package org.opensearch.index.analysis;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.vi.VietnameseAnalyzer;
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;

/**
 * Factory for {@link StopFilter}
 *
 * @author duydo
 */
public class VietnameseStopTokenFilterFactory extends AbstractTokenFilterFactory {

    private final CharArraySet stopWords;

    public VietnameseStopTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        stopWords = Analysis.parseStopWords(env, settings, VietnameseAnalyzer.getDefaultStopSet());
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new StopFilter(tokenStream, stopWords);
    }
}