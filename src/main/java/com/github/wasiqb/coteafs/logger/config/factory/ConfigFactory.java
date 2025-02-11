/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.logger.config.factory;

import java.net.URI;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;

/**
 * @author wasiq.bhamla
 * @since 17-Jun-2017 4:48:40 PM
 */
@Plugin (name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order (1)
public class ConfigFactory extends ConfigurationFactory {
	/*
	 * (non-Javadoc)
	 * @see
	 * org.apache.logging.log4j.core.config.ConfigurationFactory#getConfiguration(
	 * org.apache.logging.log4j.core.LoggerContext,
	 * org.apache.logging.log4j.core.config.ConfigurationSource)
	 */
	@Override
	public Configuration getConfiguration (final LoggerContext loggerContext,
		final ConfigurationSource source) {
		return getConfiguration (loggerContext, source.toString (), null);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.apache.logging.log4j.core.config.ConfigurationFactory#getConfiguration(
	 * org.apache.logging.log4j.core.LoggerContext, java.lang.String, java.net.URI)
	 */
	@Override
	public Configuration getConfiguration (final LoggerContext loggerContext, final String name,
		final URI configLocation) {
		final ConfigBuilder builder = new ConfigBuilder ();
		return builder.build (name, newConfigurationBuilder ());
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.apache.logging.log4j.core.config.ConfigurationFactory#getSupportedTypes()
	 */
	@Override
	protected String [] getSupportedTypes () {
		return new String [] { "*" };
	}
}