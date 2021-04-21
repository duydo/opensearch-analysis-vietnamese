/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opensearch.index.analysis;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.vi.VietnameseAnalyzer;
import org.opensearch.analysis.VietnameseConfig;
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;

/**
 * Provider for {@link VietnameseAnalyzer}
 *
 * @author duydo
 */
public class VietnameseAnalyzerProvider extends AbstractIndexAnalyzerProvider<VietnameseAnalyzer> {
    private final VietnameseAnalyzer analyzer;

    public VietnameseAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        final CharArraySet stopWords = Analysis.parseStopWords(env, settings, VietnameseAnalyzer.getDefaultStopSet());
        analyzer = new VietnameseAnalyzer(new VietnameseConfig(settings), stopWords);
    }

    @Override
    public VietnameseAnalyzer get() {
        return analyzer;
    }
}
